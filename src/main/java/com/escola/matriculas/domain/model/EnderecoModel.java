package com.escola.matriculas.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tb_Endereco")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    @OneToOne(mappedBy = "endereco")
    private AlunoModel alunoModel;
}
