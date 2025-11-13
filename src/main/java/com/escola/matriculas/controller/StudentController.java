package com.escola.matriculas.controller;

import com.escola.matriculas.domain.dto.StudentDetails;
import com.escola.matriculas.domain.dto.StudentRequestDTO;
import com.escola.matriculas.domain.dto.StudentResponseDTO;
import com.escola.matriculas.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollment")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @Operation(description = "Create a student and search for their full address using the zip code.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Student successfully enrolled!"),
            @ApiResponse(responseCode = "409", description = "Student already enrolled!")
    })
    @PostMapping
    public ResponseEntity<Object> creatAluno(@RequestBody @Valid StudentRequestDTO studentRequestDTO){
        StudentResponseDTO student = studentService.studentFullAddress(studentRequestDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(student);
    }
}
