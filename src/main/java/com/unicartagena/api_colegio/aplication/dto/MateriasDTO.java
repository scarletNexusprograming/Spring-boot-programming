package com.unicartagena.api_colegio.aplication.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MateriasDTO {
    private Long id;
    private String codigo;
    private String nombre;
    private String descripcion;
}
