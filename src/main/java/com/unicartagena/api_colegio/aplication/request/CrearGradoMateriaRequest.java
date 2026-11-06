package com.unicartagena.api_colegio.aplication.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

// Datos que se deben enviar para crear o actualizar una asignación grado-materia
@Getter
@Setter
public class CrearGradoMateriaRequest {

    @NotNull
    @Min(1) // evita horas en 0 o negativas
    private Integer horasSemanales;
}
