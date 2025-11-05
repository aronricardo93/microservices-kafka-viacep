package com.escola.matriculas.controller;

import com.escola.matriculas.domain.dto.AlunoDetails;
import com.escola.matriculas.domain.dto.AlunoRequestDTO;
import com.escola.matriculas.domain.dto.AlunoResponseDTO;
import com.escola.matriculas.service.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matricula")
public class AlunoController {

    private KafkaTemplate<String, Object> kafkaTemplate;

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService, KafkaTemplate kafkaTemplate){
        this.alunoService = alunoService;
    }

    @Operation(description = "Lista todos alunos")
    @GetMapping("/alunos")
    public ResponseEntity<List<AlunoResponseDTO>> getAlunos(){
        return ResponseEntity.ok().body(alunoService.getAllAlunos());
    }

    @Operation(description = "Busca aluno pelo id")
    @GetMapping("/aluno/{id}")
    public ResponseEntity<AlunoResponseDTO> getAluno(@PathVariable Long id){
        return ResponseEntity.ok().body(alunoService.getAlunoById(id));
    }

    @Operation(description = "Cria aluno e busca endereço completo pelo CEP")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Aluno matriculado com sucesso!"),
            @ApiResponse(responseCode = "409", description = "Aluno já matriculado!")
    })
    @PostMapping
    public ResponseEntity<Object> creatAluno(@RequestBody @Valid AlunoRequestDTO alunoRequestDTO){
        AlunoDetails aluno = alunoService.alunoEnderecoCompleto(alunoRequestDTO);
        //kafkaTemplate.send("cursos-topico", aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
    }
}
