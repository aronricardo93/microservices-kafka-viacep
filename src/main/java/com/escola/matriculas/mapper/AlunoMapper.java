package com.escola.matriculas.mapper;

import com.escola.matriculas.domain.dto.AlunoRequestDTO;
import com.escola.matriculas.domain.dto.AlunoResponseDTO;
import com.escola.matriculas.domain.model.AlunoModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface AlunoMapper {

    AlunoModel toEntity(AlunoRequestDTO alunoRequestDTO);

    List<AlunoResponseDTO> toListDTO(List<AlunoModel> alunos);

    AlunoResponseDTO toDTO(AlunoModel aluno);
}
