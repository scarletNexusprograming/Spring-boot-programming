package com.unicartagena.api_colegio.aplication.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesoresDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private Long identificacion;
    private String correo;
    private String telefono;
    private String especialidad;
}
