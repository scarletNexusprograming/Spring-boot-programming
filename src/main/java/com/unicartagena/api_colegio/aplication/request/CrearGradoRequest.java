package com.unicartagena.api_colegio.aplication.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

// Datos que se deben enviar para crear o actualizar un grado
@Getter
@Setter
public class CrearGradoRequest {

    @NotBlank
    @Size(max = 30)
    private String nombre;

    @NotBlank
    @Size(max = 20)
    private String nivel;
}
