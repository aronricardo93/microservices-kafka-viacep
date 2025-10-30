package com.escola.matriculas.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AlunoDetails {
    private String nome;
    private String dataNascimento;
    private String cpf;
    private EnderecoDetails endereco;
}
