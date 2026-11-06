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
@Table(name = "material_academico")
@NoArgsConstructor
public class MaterialAcademico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_academico_id")
    private Long id;

    @Column(name = "titulo", nullable = false, length = 150)
    private String titulo;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Column(name = "tipo", nullable = false, length = 30)
    private String tipo;

    @Column(name = "url", nullable = false, length = 500)
    private String url;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @PrePersist
    protected void alCrear() {
        fechaCreacion = LocalDateTime.now();
    }
}
