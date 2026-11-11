package com.unicartagena.api_colegio.aplication.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearMatriculaRequest {

    @NotBlank(message = "El periodo academico es obligatorio")
    @Size(max = 10, message = "El periodo academico no puede superar los 10 caracteres")
    private String periodoAcademico;

    @NotBlank(message = "El estado es obligatorio")
    @Size(max = 20, message = "El estado no puede superar los 20 caracteres")
    @Pattern(regexp = "ACTIVA|RETIRADA|FINALIZADA",
            message = "El estado debe ser ACTIVA, RETIRADA o FINALIZADA")
    private String estado;

    @Size(max = 255, message = "Las observaciones no pueden superar los 255 caracteres")
    private String observaciones;
}
