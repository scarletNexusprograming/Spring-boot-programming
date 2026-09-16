package com.unicartagena.api_colegio.aplication.service.impl;

import com.unicartagena.api_colegio.aplication.dto.EstudiantesDTO;
import com.unicartagena.api_colegio.aplication.entities.Estudiantes;
import com.unicartagena.api_colegio.aplication.request.CrearEstudianteRequest;

public interface IEstudianteService {
EstudiantesDTO create(CrearEstudianteRequest crearEstudianteRequest);
}
