package com.escola.matriculas.domain.dto;

import java.util.Date;

public record StudentResponseDTO(
        String name,
        String birthDate,
        String cpf,
        Date date) {}
