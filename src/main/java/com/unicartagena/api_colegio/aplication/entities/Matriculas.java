package com.unicartagena.api_colegio.aplication.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "matriculas")
@NoArgsConstructor
public class Matriculas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matricula_id")
    private Long id;

    @Column(name = "periodo_academico", nullable = false, length = 10)
    private String periodoAcademico;

    @Column(name = "estado", nullable = false, length = 20)
    private String estado;

    @Column(name = "observaciones", length = 255)
    private String observaciones;

    @Column(name = "fecha_matricula", nullable = false, updatable = false)
    private LocalDateTime fechaMatricula;

    @PrePersist
    protected void alCrear() {
        fechaMatricula = LocalDateTime.now();
    }
}