package com.escola.matriculas.mapper;

import com.escola.matriculas.domain.dto.StudentDetails;
import com.escola.matriculas.domain.dto.StudentResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface StudentMapper {

    StudentResponseDTO toResponse (StudentDetails studentDetails);

}
