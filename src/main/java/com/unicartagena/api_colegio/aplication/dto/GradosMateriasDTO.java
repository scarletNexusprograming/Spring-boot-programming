package com.unicartagena.api_colegio.aplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradosMateriasDTO {
    private Long id;
    private Integer horasSemanales;
}