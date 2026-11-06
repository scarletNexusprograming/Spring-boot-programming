package com.unicartagena.api_colegio.aplication.service;

import java.util.List;

import com.unicartagena.api_colegio.aplication.dto.MatriculasDTO;
import com.unicartagena.api_colegio.aplication.request.CrearMatriculaRequest;

public interface IMatriculaService {

    MatriculasDTO crear(CrearMatriculaRequest request);

    List<MatriculasDTO> listar();

    MatriculasDTO obtenerPorId(Long id);

    MatriculasDTO actualizar(Long id, CrearMatriculaRequest request);

    void eliminar(Long id);
}
