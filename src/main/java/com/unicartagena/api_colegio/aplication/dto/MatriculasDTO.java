package com.unicartagena.api_colegio.aplication.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculasDTO {

    private Long id;
    private String periodoAcademico;
    private String estado;
    private String observaciones;
    private LocalDateTime fechaMatricula;
}
