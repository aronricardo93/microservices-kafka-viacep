package com.escola.matriculas.domain.dto;

import java.util.Date;

public record AlunoResponseDTO(
        String nome,
        String dataNascimento,
        String cpf,
        Date data) {}
