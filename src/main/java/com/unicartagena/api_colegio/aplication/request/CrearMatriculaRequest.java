package com.unicartagena.api_colegio.aplication.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrearMatriculaRequest {

    @NotNull
    private Long estudianteId;

    @NotNull
    private Long gradoId;

    @NotNull
    private LocalDate fechaMatricula;

    @NotBlank
    private String periodoAcademico;
}