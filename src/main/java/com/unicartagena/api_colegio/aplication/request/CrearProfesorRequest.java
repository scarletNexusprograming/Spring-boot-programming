package com.unicartagena.api_colegio.aplication.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

// Datos que se deben enviar para crear o actualizar un profesor
@Getter
@Setter
public class CrearProfesorRequest {

    @NotBlank
    @Size(max = 20)
    private String nombre;

    @NotBlank
    @Size(max = 20)
    private String apellido;

    @NotNull
    private Long identificacion;

    @NotBlank
    @Email
    @Size(max = 70)
    private String correo;

    @Size(max = 15)
    private String telefono;

    @Size(max = 50)
    private String especialidad;
}
