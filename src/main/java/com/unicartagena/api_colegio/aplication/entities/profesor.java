package com.unicartagena.api_colegio.aplication.entities;

import jakarta.persistence.*;
import lombok.*;

public class profesor {

    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
}
