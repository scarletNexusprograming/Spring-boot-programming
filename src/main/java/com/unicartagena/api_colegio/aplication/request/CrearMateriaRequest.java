package com.unicartagena.api_colegio.aplication.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

// Datos que se deben enviar para crear o actualizar una materia
@Getter
@Setter
public class CrearMateriaRequest {

    @NotBlank
    @Size(max = 10)
    private String codigo;

    @NotBlank
    @Size(max = 50)
    private String nombre;

    @Size(max = 200)
    private String descripcion;
}
