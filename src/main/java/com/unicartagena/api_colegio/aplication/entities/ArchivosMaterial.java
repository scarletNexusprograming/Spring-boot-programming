package com.unicartagena.api_colegio.aplication.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "rchivos_material")
@NoArgsConstructor
public class ArchivosMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "archivo_material_id")
    private Long id;

    @Column(name = "nombre_original", nullable = false, length = 255)
    private String nombreOriginal;

    @Column(name = "nombre_almacenado", nullable = false, length = 255)
    private String nombreAlmacenado;

    @Column (name = "tipo_mime", nullable = false, length = 100)
    private String tipo_mine;

    @Column (name = "tamaño_bytes", nullable = false)
    private Long tamañoBytes;

    @Column (name = "fecha_subida", nullable = false, updatable = false)
    private LocalDateTime fechasubida;

    @PrePersist
    protected void alCrear(){
        if(fechasubida == null){
            fechasubida = LocalDateTime.now();
        }
    }
}
