
package com.unicartagena.api_colegio.aplication.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "asignaciones_docentes")
@NoArgsConstructor
public class AsignacionDocente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asignacion_docente_id")
    private Long id;

    @Column(name = "anio_academico", nullable = false)
    private Integer anioAcademico;

    @Column(name = "fecha_asignacion", nullable = false, updatable = false)
    private LocalDateTime fechaAsignacion;

    @Column(name = "estado", nullable = false)
    private Boolean estado = true;

    @PrePersist
    protected void alCrear() {
        if (fechaAsignacion == null) {
            fechaAsignacion = LocalDateTime.now();
        }

        if (estado == null) {
            estado = true;
            
        }
    }
}
