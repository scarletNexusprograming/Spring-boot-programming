package com.unicartagena.api_colegio.aplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolesDTO {

    private Long id;
    private String nombre;
    private String descripcion;
}
