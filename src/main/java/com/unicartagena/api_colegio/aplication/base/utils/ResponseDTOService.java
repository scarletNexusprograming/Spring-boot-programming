package com.unicartagena.api_colegio.aplication.base.utils;

import com.unicartagena.api_colegio.aplication.base.configs.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/*
 * Esta clase genera las respuestas HTTP uniformes de la API:
 * código, mensaje y, opcionalmente, los datos.
 */
@Service
public class ResponseDTOService {

    // Versión principal: sirve para cualquier tipo de dato (un DTO, una lista, null...)
    public <T> ResponseEntity<ResponseDTO<T>> response(HttpStatus status, String message, T data) {
        ResponseDTO<T> body = new ResponseDTO<>(status.value(), message, data);
        return new ResponseEntity<>(body, status);
    }

    // Versión con mensaje propio y sin datos (por ejemplo, al eliminar)
    public <T> ResponseEntity<ResponseDTO<T>> response(HttpStatus status, String message) {
        return response(status, message, null);
    }

    // Versión del profesor: solo código y mensaje estándar de HTTP
    public <T> ResponseEntity<ResponseDTO<T>> response(HttpStatus status) {
        return response(status, status.getReasonPhrase(), null);
    }
}
