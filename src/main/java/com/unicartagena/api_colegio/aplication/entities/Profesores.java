package com.unicartagena.api_colegio.aplication.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "profesores")
@NoArgsConstructor
public class Profesores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profesor_id")
    private Long id;

    @Column(name = "nombre", length = 20, nullable = false)
    private String nombre;

    @Column(name = "apellido", length = 20, nullable = false)
    private String apellido;

    @Column(name = "identificacion", nullable = false, unique = true)
    private Long identificacion;

    @Column(name = "correo", length = 70, nullable = false)
    private String correo;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "especialidad", length = 50)
    private String especialidad;
}
