package com.unicartagena.api_colegio.aplication.base.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String mensaje) {
        super(mensaje);
    }
}