package com.escola.matriculas.repositories;

import com.escola.matriculas.domain.model.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository  extends JpaRepository<AlunoModel, Long> {}