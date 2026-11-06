package com.unicartagena.api_colegio.aplication.service;

import com.unicartagena.api_colegio.aplication.dto.MateriasDTO;
import com.unicartagena.api_colegio.aplication.request.CrearMateriaRequest;

import java.util.List;

public interface IMateriaService {

    List<MateriasDTO> listarTodos();

    MateriasDTO buscarPorId(Long id);

    MateriasDTO crear(CrearMateriaRequest request);

    MateriasDTO actualizar(Long id, CrearMateriaRequest request);

    void eliminarPorId(Long id);
}
