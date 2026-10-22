
package com.unicartagena.api_colegio.aplication.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UsuariosDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private Boolean estado;
    private LocalDateTime fechaCreacion;
}
