package com.unicartagena.api_colegio.aplication.service;

import com.unicartagena.api_colegio.aplication.dto.ProfesoresDTO;
import com.unicartagena.api_colegio.aplication.request.CrearProfesorRequest;

import java.util.List;

public interface IProfesorService {

    List<ProfesoresDTO> listarTodos();

    ProfesoresDTO buscarPorId(Long id);

    ProfesoresDTO crear(CrearProfesorRequest request);

    ProfesoresDTO actualizar(Long id, CrearProfesorRequest request);

    void eliminarPorId(Long id);
}
