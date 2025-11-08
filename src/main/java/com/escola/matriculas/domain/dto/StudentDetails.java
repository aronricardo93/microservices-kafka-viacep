package com.escola.matriculas.domain.dto;

import lombok.Data;

@Data
public class StudentDetails {
    private String name;
    private String birthDate;
    private String cpf;
    private AddressDetails address;
}
