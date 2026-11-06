package com.unicartagena.api_colegio.aplication.service;

import com.unicartagena.api_colegio.aplication.dto.EstudiantesDTO;
import com.unicartagena.api_colegio.aplication.request.CrearEstudianteRequest;

import java.util.List;

public interface IEstudianteService {

    List<EstudiantesDTO> listarTodos();

    EstudiantesDTO buscarPorId(Long id);

    EstudiantesDTO crear(CrearEstudianteRequest request);

    EstudiantesDTO actualizar(Long id, CrearEstudianteRequest request);

    void eliminarPorId(Long id);
}