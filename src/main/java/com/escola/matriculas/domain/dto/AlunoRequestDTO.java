package com.escola.matriculas.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record AlunoRequestDTO(
    @NotBlank(message = "O nome deve ser informado!") String nome,
    @NotBlank(message = "A data de nascimento deve ser informada!") String dataNascimento,
    @NotBlank(message = "O CPF deve ser informado!") @CPF(message = "CPF inválido!") String cpf,
    @NotBlank(message = "O CEP deve ser informado!") String cep
) {}
