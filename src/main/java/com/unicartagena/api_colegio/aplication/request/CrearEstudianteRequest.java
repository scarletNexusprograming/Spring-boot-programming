package com.unicartagena.api_colegio.aplication.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearEstudianteRequest {
// esta clase request define los datos que la persona debe llenar para crear
// un nuevo estudiante
    @NotNull
    @Column(length = 40)
    @NotBlank
    private String nombre;
    @NotNull
    @Column(length = 50)
    @NotBlank
    private String apellido;
    @NotNull
    @Column(length = 80)
    @NotBlank
    private Long identificacion;
    @NotNull
    @Column(length = 80)
    @NotBlank
    private String correo;
    @NotNull
    @Column(length = 12)
    @NotBlank
    private  Integer edad;

}
