package com.unicartagena.api_colegio.aplication.service;

import com.unicartagena.api_colegio.aplication.dto.GradosDTO;
import com.unicartagena.api_colegio.aplication.request.CrearGradoRequest;

import java.util.List;

public interface IGradoService {

    List<GradosDTO> listarTodos();

    GradosDTO buscarPorId(Long id);

    GradosDTO crear(CrearGradoRequest request);

    GradosDTO actualizar(Long id, CrearGradoRequest request);

    void eliminarPorId(Long id);
}
