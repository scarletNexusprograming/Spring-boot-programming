package com.unicartagena.api_colegio.aplication.service;

import com.unicartagena.api_colegio.aplication.dtos.MatriculaDTO;
import com.unicartagena.api_colegio.aplication.request.CrearMatriculaRequest;

import java.util.List;

public interface IMatriculaService {

    MatriculaDTO create(CrearMatriculaRequest crearMatriculaRequest);

    List<MatriculaDTO> findAll();
}