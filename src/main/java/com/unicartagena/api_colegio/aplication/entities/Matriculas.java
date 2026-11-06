package com.unicartagena.api_colegio.aplication.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

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
