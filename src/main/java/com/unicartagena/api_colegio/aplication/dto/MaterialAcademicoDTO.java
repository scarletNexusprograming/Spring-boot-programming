package com.unicartagena.api_colegio.aplication.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialAcademicoDTO {

    private Long id;
    private String titulo;
    private String descripcion;
    private String tipo;
    private String url;
    private LocalDateTime fechaCreacion;
}
