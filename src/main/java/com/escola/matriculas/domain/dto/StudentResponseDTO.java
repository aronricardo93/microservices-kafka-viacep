package com.escola.matriculas.domain.dto;

import com.escola.matriculas.domain.enums.Status;
import com.escola.matriculas.domain.enums.TechnicalCourse;

public record StudentResponseDTO(String protocol, String name, TechnicalCourse technicalCourse, Status status) {
}
