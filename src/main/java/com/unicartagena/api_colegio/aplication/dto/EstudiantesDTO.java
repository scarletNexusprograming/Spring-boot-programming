package com.unicartagena.api_colegio.aplication.dto;


import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudiantesDTO {
    private Long id;
    private String nombre ;
    private String apellido;
    private Integer edad;
    private String correo;
    private Long identificacion;
}
