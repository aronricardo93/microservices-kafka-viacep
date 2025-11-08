package com.escola.matriculas.repositories;

import com.escola.matriculas.domain.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {}