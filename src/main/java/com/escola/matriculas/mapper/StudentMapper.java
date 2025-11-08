package com.escola.matriculas.mapper;

import com.escola.matriculas.domain.dto.StudentRequestDTO;
import com.escola.matriculas.domain.dto.StudentResponseDTO;
import com.escola.matriculas.domain.model.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface StudentMapper {

    Student toEntity(StudentRequestDTO studentRequestDTO);

    List<StudentResponseDTO> toListDTO(List<Student> students);

    StudentResponseDTO toDTO(Student student);
}
