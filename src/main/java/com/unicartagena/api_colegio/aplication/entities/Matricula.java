package com.unicartagena.api_colegio.aplication.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "matriculas")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación: muchas matrículas pertenecen a UN estudiante
    @NonNull
    @ManyToOne
    @JoinColumn(name = "estudiante_id", nullable = false)
    private Estudiantes estudiante;

    // Relación: muchas matrículas pertenecen a UN grado
    @NonNull
    @ManyToOne
    @JoinColumn(name = "grado_id", nullable = false)
    private Grados grado;

    @NonNull
    @Column(name = "fecha_matricula")
    private LocalDate fechaMatricula;

    @NonNull
    @Column(length = 20)
    private String periodoAcademico;

    @NonNull
    @Column(length = 20)
    private String estado;
}