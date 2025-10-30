package com.escola.matriculas.domain.dto;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record AlunoRequestDTO(
    @NotNull(message = "O nome deve ser informado!") String nome,
    @NotNull(message = "A data de nascimento deve ser informada!") String dataNascimento,
    @NotNull(message = "O CPF deve ser informado!") @CPF(message = "CPF inválido!") String cpf,
    @NotNull(message = "O CEP deve ser informado!") String cep
) {}
