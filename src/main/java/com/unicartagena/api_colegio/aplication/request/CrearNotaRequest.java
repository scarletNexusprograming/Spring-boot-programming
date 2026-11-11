package com.unicartagena.api_colegio.aplication.request;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CrearNotaRequest {

    @NotNull(message = "La calificación es obligatoria")
    @DecimalMin(value = "0.0", message = "La nota mínima es 0.0")
    @DecimalMax(value = "5.0", message = "La nota máxima es 5.0")
    private BigDecimal valor;

    @NotNull(message = "El periodo es obligatorio")
    @Positive(message = "El periodo debe ser mayor que cero")
    private Integer periodo;

    @NotBlank(message = "El tipo de evaluación es obligatorio")
    private String tipoEvaluacion;

    private String observacion;

    @NotNull(message = "El ID del estudiante es obligatorio")
    @Positive(message = "El ID del estudiante debe ser mayor que cero")
    private Long estudianteId;

    @NotNull(message = "El ID de la materia es obligatorio")
    @Positive(message = "El ID de la materia debe ser mayor que cero")
    private Long materiaId;
}