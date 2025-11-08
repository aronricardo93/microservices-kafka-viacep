package com.escola.matriculas.domain.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record StudentRequestDTO(
    @NotBlank(message = "Name is required!") String name,
    @NotBlank(message = "Birth date is required.!") String bithDate,
    @NotBlank(message = "CPF is required.") @CPF(message = "Invalid CPF number!") String cpf,
    @NotBlank(message = "ZIP code is required.") String zipCode
) {}
