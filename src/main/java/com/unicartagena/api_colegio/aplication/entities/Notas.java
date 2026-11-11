package com.unicartagena.api_colegio.aplication.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notas")
@NoArgsConstructor
public class Notas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nota_id")
    private Long id;

    @Column(name = "valor", precision = 3, scale = 2, nullable = false)
    @DecimalMin(value = "0.0", message = "La nota no puede ser menor a 0.0")
    @DecimalMax(value = "5.0", message = "La nota no puede ser mayor a 5.0")
    private BigDecimal valor;

    @Column(name = "periodo", nullable = false)
    private Integer periodo;

    @Column(name = "tipo_evaluacion", length = 50, nullable = false)
    private String tipoEvaluacion;

    @Column(name = "observacion", length = 255)
    private String observacion;

    @Column(name = "fecha_registro", nullable = false, updatable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "estudiante_id", nullable = false)
    private Long estudianteId;

    @Column(name = "materia_id", nullable = false)
    private Long materiaId;

    @PrePersist
    public void asignarFechaRegistro() {
        if (fechaRegistro == null) {
            fechaRegistro = LocalDateTime.now();
        }
    }
}