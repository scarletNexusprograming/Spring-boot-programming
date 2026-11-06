package com.unicartagena.api_colegio.aplication.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearMaterialAcademicoRequest {

    @NotBlank(message = "El titulo es obligatorio")
    @Size(max = 150, message = "El titulo no puede superar los 150 caracteres")
    private String titulo;

    @Size(max = 500, message = "La descripcion no puede superar los 500 caracteres")
    private String descripcion;

    @NotBlank(message = "El tipo es obligatorio")
    @Size(max = 30, message = "El tipo no puede superar los 30 caracteres")
    @Pattern(regexp = "GUIA|VIDEO|DOCUMENTO|ENLACE",
            message = "El tipo debe ser GUIA, VIDEO, DOCUMENTO o ENLACE")
    private String tipo;

    @NotBlank(message = "La url del recurso es obligatoria")
    @Size(max = 500, message = "La url no puede superar los 500 caracteres")
    private String url;
}
