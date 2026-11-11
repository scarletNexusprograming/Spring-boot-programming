package com.unicartagena.api_colegio.aplication.service;

import com.unicartagena.api_colegio.aplication.dto.NotasDTO;
import com.unicartagena.api_colegio.aplication.request.CrearNotaRequest;

import java.util.List;

public interface INotasService {

    NotasDTO crear(CrearNotaRequest request);

    List<NotasDTO> listarTodas();

    NotasDTO buscarPorId(Long id);

    List<NotasDTO> buscarPorEstudiante(Long estudianteId);

    List<NotasDTO> buscarPorMateria(Long materiaId);

    List<NotasDTO> buscarPorPeriodo(Integer periodo);

    List<NotasDTO> buscarPorEstudianteYMateria(
            Long estudianteId,
            Long materiaId
    );

    NotasDTO actualizar(Long id, CrearNotaRequest request);

    void eliminarPorId(Long id);
}