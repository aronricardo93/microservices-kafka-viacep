package com.escola.matriculas.service;

import com.escola.matriculas.domain.dto.StudentDetails;
import com.escola.matriculas.domain.dto.StudentRequestDTO;
import com.escola.matriculas.domain.dto.StudentResponseDTO;
import com.escola.matriculas.domain.model.Student;
import com.escola.matriculas.mapper.StudentMapper;
import com.escola.matriculas.repositories.StudentRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final ZipCodeService zipCodeService;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public StudentService(StudentRepository  studentRepository, StudentMapper studentMapper, ZipCodeService zipCodeService, KafkaTemplate<String, Object> kafkaTemplate){
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.zipCodeService = zipCodeService;
        this.kafkaTemplate = kafkaTemplate;
    }

    public List<StudentResponseDTO> getAllStudents(){
        return studentMapper.toListDTO(studentRepository.findAll());
    }

    public StudentResponseDTO getStudentById(Long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student with ID " + id + " not found!"));
        return studentMapper.toDTO(student);
    }

    public StudentDetails studentFullAddress(StudentRequestDTO studentRequestDTO){
        StudentDetails studentDetails = new StudentDetails();
        studentDetails.setName(studentRequestDTO.name());
        studentDetails.setBirthDate(studentRequestDTO.bithDate());
        studentDetails.setCpf(studentRequestDTO.cpf());

        studentDetails.setAddress(zipCodeService.requestCEP(studentRequestDTO.zipCode()));

        kafkaTemplate.send("cursos-topico", studentDetails);

        return studentDetails;
    }

    public void deleteAluno(Long id){
        studentRepository.deleteById(id);
    }
}
