package com.escola.matriculas.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDetails {
    private String cep;
    private String logradouro;
    private String bairro;
    private String estado;
    private String localidade;
}
