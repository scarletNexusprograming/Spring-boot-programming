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

    @NotBlank (message = "El nombre el obligatorio ")
    @Size(max = 20, message = "El nombre no deve superar los 20 caracteres")// esto es para poner un limite de caracteres
    private String nombre;

    @NotBlank(message = "el apellido es obligatorio")
    @Size(max = 20, message = "el apellido  no puede superar los 20 caracteres ")
    private String apellido;

    @NotNull(message = "no pude ser un dati nulo ")
    @Size(max = 10, message = "la identificacion solo contiene 10 caracteres ")
    private Long identificacion;

    @NotBlank(message = "email es obligatorio")
    @Email
    @Size(max = 70, message = "maximo 70 caracteres")
    private String correo;

    @NotNull(message = "dato no nulo")
    @Min(1)//evita edades de o o negativas
    private Integer edad;
}