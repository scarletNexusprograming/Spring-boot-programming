package com.unicartagena.api_colegio.aplication.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "grados")
@NoArgsConstructor
public class Grados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grado_id")
    private Long id;

    @Column(name = "nombre", length = 30, nullable = false, unique = true)
    private String nombre;

    @Column(name = "nivel", length = 20, nullable = false)
    private String nivel;
}