package com.unicartagena.api_colegio.aplication.service;

import java.util.List;

import com.unicartagena.api_colegio.aplication.dto.MaterialAcademicoDTO;
import com.unicartagena.api_colegio.aplication.request.CrearMaterialAcademicoRequest;

public interface IMaterialAcademicoService {

    MaterialAcademicoDTO crear(CrearMaterialAcademicoRequest request);

    List<MaterialAcademicoDTO> listar();

    MaterialAcademicoDTO obtenerPorId(Long id);

    MaterialAcademicoDTO actualizar(Long id, CrearMaterialAcademicoRequest request);

    void eliminar(Long id);
}
