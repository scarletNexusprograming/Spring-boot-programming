package com.unicartagena.api_colegio.aplication.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "materias")
@NoArgsConstructor
public class Materias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "materia_id")
    private Long id;

    @Column(name = "codigo", length = 10, nullable = false, unique = true)
    private String codigo;

    @Column(name = "nombre", length = 50, nullable = false, unique = true)
    private String nombre;

    @Column(name = "descripcion", length = 200)
    private String descripcion;
}
