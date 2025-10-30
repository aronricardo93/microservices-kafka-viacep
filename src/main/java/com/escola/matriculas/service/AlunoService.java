package com.escola.matriculas.service;

import com.escola.matriculas.domain.dto.AlunoDetails;
import com.escola.matriculas.domain.dto.AlunoRequestDTO;
import com.escola.matriculas.domain.dto.AlunoResponseDTO;
import com.escola.matriculas.domain.model.AlunoModel;
import com.escola.matriculas.mapper.AlunoMapper;
import com.escola.matriculas.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService{

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoMapper alunoMapper;

    @Autowired
    private CepService cepService;

    public List<AlunoResponseDTO> getAllAlunos(){
        return alunoMapper.toListDTO(alunoRepository.findAll());
    }

    public AlunoResponseDTO getAlunoById(Long id){
        AlunoModel aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno com id " + id + "não encontrado!"));
        return alunoMapper.toDTO(aluno);
    }

//    public AlunoModel putAluno(AlunoRequestDTO dto){
//       AlunoModel aluno = getAlunoById(dto.getId()).get();
//
//       aluno.setNome(dto.nome());
//       aluno.setDataNascimento(dto.dataNascimento());
//       aluno.setCpf(dto.cpf());
//       aluno.setData(new Date());
//
//       alunoRepository.save(aluno);
//
//       return aluno;
//    }

    public AlunoDetails alunoEnderecoCompleto(AlunoRequestDTO alunoRequestDTO){
        AlunoDetails alunoDetails = new AlunoDetails();
        alunoDetails.setNome(alunoRequestDTO.nome());
        alunoDetails.setDataNascimento(alunoRequestDTO.dataNascimento());
        alunoDetails.setCpf(alunoRequestDTO.cpf());

        alunoDetails.setEndereco(cepService.requestCEP(alunoRequestDTO.cep()));

        return alunoDetails;
    }

    public void deleteAluno(Long id){
        alunoRepository.deleteById(id);
    }
}
