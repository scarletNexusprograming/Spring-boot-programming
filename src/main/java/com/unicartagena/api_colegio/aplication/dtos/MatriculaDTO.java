package com.unicartagena.api_colegio.aplication.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaDTO {

    private Long id;
    private Long estudianteId;
    private String estudianteNombre;
    private Long gradoId;
    private String gradoNombre;
    private LocalDate fechaMatricula;
    private String periodoAcademico;
    private String estado;
}