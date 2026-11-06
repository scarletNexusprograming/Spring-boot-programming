package com.unicartagena.api_colegio.aplication.service;

import java.util.List;

import com.unicartagena.api_colegio.aplication.dto.RolesDTO;
import com.unicartagena.api_colegio.aplication.request.CrearRolRequest;

public interface IRolService {

    RolesDTO crear(CrearRolRequest request);

    List<RolesDTO> listar();

    RolesDTO obtenerPorId(Long id);

    RolesDTO actualizar(Long id, CrearRolRequest request);

    void eliminar(Long id);
}
