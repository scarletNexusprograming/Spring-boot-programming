package com.unicartagena.api_colegio.aplication.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

// Esta clase request define los datos que la persona debe llenar
// para crear un nuevo estudiante
@Getter
@Setter
public class CrearEstudianteRequest {

    @NotBlank
    @Size(max = 20)// esto es para poner un limite de caracteres
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

    @NotNull
    @Min(1)//evita edades de o o negativas
    private Integer edad;
}