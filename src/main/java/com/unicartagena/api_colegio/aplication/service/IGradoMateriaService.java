package com.unicartagena.api_colegio.aplication.service;

import com.unicartagena.api_colegio.aplication.dto.GradosMateriasDTO;
import com.unicartagena.api_colegio.aplication.request.CrearGradoMateriaRequest;

import java.util.List;

public interface IGradoMateriaService {

    List<GradosMateriasDTO> listarTodos();

    GradosMateriasDTO buscarPorId(Long id);

    GradosMateriasDTO crear(CrearGradoMateriaRequest request);

    GradosMateriasDTO actualizar(Long id, CrearGradoMateriaRequest request);

    void eliminarPorId(Long id);
}
