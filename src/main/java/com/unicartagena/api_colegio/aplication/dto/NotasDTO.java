package com.unicartagena.api_colegio.aplication.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class NotasDTO {

    private Long id;

    private BigDecimal valor;

    private Integer periodo;

    private String tipoEvaluacion;

    private String observacion;

    private LocalDateTime fechaRegistro;

    private Long estudianteId;

    private Long materiaId;
}