package com.escola.matriculas.domain.dto;

import com.escola.matriculas.domain.enums.TechnicalCourse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record StudentRequestDTO(
    @NotBlank(message = "Name is required!") String name,
    @NotBlank(message = "Birth date is required.!") String birthDate,
    @NotBlank(message = "CPF is required.") @CPF(message = "Invalid CPF number!") String cpf,
    @NotNull(message = "Technical course is required.") TechnicalCourse technicalCourse,
    @NotBlank(message = "ZIP code is required.") String zipCode
) {}
