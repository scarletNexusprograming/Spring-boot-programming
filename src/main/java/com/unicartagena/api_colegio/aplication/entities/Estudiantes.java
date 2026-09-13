package com.unicartagena.api_colegio.aplication.entities;

import jakarta .persistence.*;
import lombok.*;

@Data
@Entity
@Table (name = "estudiantes")
@NoArgsConstructor

public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "estudiante_id")
    private  Long id;

    @Column (name = "nombre", length = 20,nullable = false)
    private String nombre;

    @Column (name = "apellido", length = 20 ,nullable = false)
    private String apellido;

    @Column (name = "edad", nullable = false )
    private Integer edad ;

    @Column (name = "correo",length = 70, nullable = false)
    private String correo ;

    @Column (name = "identificacion", nullable = false, unique = true)
    private Long identificacion;

}