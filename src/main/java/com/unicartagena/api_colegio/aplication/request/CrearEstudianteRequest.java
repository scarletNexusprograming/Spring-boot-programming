package com.unicartagena.api_colegio.aplication.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Digits;
import lombok.Getter;
import lombok.Setter;

// Esta clase Request define los datos que la persona debe llenar
// para crear un nuevo estudiante

@Getter
@Setter
public class CrearEstudianteRequest {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 20, message = "El nombre no debe superar los 20 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 20, message = "El apellido no puede superar los 20 caracteres")
    private String apellido;

    @NotNull(message = "La identificación es obligatoria")
    @Digits(integer = 10, fraction = 0,
            message = "La identificación debe contener máximo 10 dígitos")
    private Long identificacion;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo debe tener un formato válido")
    @Size(max = 70, message = "El correo no puede superar los 70 caracteres")
    private String correo;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 1, message = "La edad debe ser mayor que cero")
    @Max(value = 120, message = "La edad no puede superar los 120 años")
    private Integer edad;
}