package com.unicartagena.api_colegio.aplication.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "grados_materias")
@NoArgsConstructor
public class GradosMaterias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grado_materia_id")
    private Long id;

    @Column(name = "horas_semanales", nullable = false)
    private Integer horasSemanales;
}