package com.escola.matriculas.domain.model;

import com.escola.matriculas.domain.enums.Curso;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "tb_aluno")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dataNascimento;

    private String cpf;

    @Enumerated(EnumType.STRING)
    private Curso curso;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private EnderecoModel endereco;

    @Column(name = "data_cadastro")
    private Date data;

}
