package com.escola.matriculas.service;

import com.escola.matriculas.domain.dto.StudentDetails;
import com.escola.matriculas.domain.dto.StudentRequestDTO;
import com.escola.matriculas.domain.dto.StudentResponseDTO;
import com.escola.matriculas.domain.enums.Status;
import com.escola.matriculas.mapper.StudentMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StudentService {

    private final StudentMapper studentMapper;
    private final ZipCodeService zipCodeService;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public StudentService(StudentMapper studentMapper, ZipCodeService zipCodeService, KafkaTemplate<String, Object> kafkaTemplate) {
        this.studentMapper = studentMapper;
        this.zipCodeService = zipCodeService;
        this.kafkaTemplate = kafkaTemplate;
    }

    public StudentResponseDTO studentFullAddress(StudentRequestDTO studentRequestDTO) {
        String protocol = UUID.randomUUID().toString();

        StudentDetails studentDetails = new StudentDetails();
        studentDetails.setName(studentRequestDTO.name());
        studentDetails.setBirthDate(studentRequestDTO.birthDate());
        studentDetails.setCpf(studentRequestDTO.cpf());
        studentDetails.setProtocol(protocol);
        studentDetails.setStatus(Status.PENDING);
        studentDetails.setTechnicalCourse(studentRequestDTO.technicalCourse());

        studentDetails.setAddress(zipCodeService.requestZipCode(studentRequestDTO.zipCode()));

        kafkaTemplate.send("enrollment-topic", studentDetails);

        return studentMapper.toResponse(studentDetails);
    }
}
