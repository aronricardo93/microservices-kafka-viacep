package com.escola.matriculas.controller;

import com.escola.matriculas.domain.dto.AlunoDetails;
import com.escola.matriculas.domain.dto.AlunoRequestDTO;
import com.escola.matriculas.domain.dto.AlunoResponseDTO;
import com.escola.matriculas.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matricula")
public class AlunoController {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    @GetMapping("/alunos")
    public ResponseEntity<List<AlunoResponseDTO>> getAlunos(){
        return ResponseEntity.ok().body(alunoService.getAllAlunos());
    }

    @GetMapping("/aluno/{id}")
    public ResponseEntity<AlunoResponseDTO> getAluno(@PathVariable Long id){
        return ResponseEntity.ok().body(alunoService.getAlunoById(id));
    }

    @PostMapping
    public ResponseEntity<Object> creatAluno(@RequestBody AlunoRequestDTO alunoRequestDTO){
        AlunoDetails aluno = alunoService.alunoEnderecoCompleto(alunoRequestDTO);
        kafkaTemplate.send("cursos-topico", aluno);
        return ResponseEntity.ok().body(aluno);
    }
}
