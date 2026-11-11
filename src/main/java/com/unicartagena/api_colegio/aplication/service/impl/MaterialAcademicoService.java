package com.unicartagena.api_colegio.aplication.service.impl;

import com.unicartagena.api_colegio.aplication.service.IMaterialAcademicoService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.unicartagena.api_colegio.aplication.dto.MaterialAcademicoDTO;
import com.unicartagena.api_colegio.aplication.entities.MaterialAcademico;
import com.unicartagena.api_colegio.aplication.repositories.MaterialAcademicoRepository;
import com.unicartagena.api_colegio.aplication.request.CrearMaterialAcademicoRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MaterialAcademicoService implements IMaterialAcademicoService {

    private final MaterialAcademicoRepository materialAcademicoRepository;

    @Override
    public MaterialAcademicoDTO crear(CrearMaterialAcademicoRequest request) {
        MaterialAcademico material = new MaterialAcademico();
        copiar(request, material);
        return aDTO(materialAcademicoRepository.save(material));
    }

    @Override
    public List<MaterialAcademicoDTO> listar() {
        return materialAcademicoRepository.findAll().stream().map(this::aDTO).toList();
    }

    @Override
    public MaterialAcademicoDTO obtenerPorId(Long id) {
        return aDTO(buscar(id));
    }

    @Override
    public MaterialAcademicoDTO actualizar(Long id, CrearMaterialAcademicoRequest request) {
        MaterialAcademico material = buscar(id);
        copiar(request, material);
        return aDTO(materialAcademicoRepository.save(material));
    }

    @Override
    public void eliminar(Long id) {
        materialAcademicoRepository.delete(buscar(id));
    }

    private MaterialAcademico buscar(Long id) {
        return materialAcademicoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Material academico no encontrado"));
    }

    private void copiar(CrearMaterialAcademicoRequest request, MaterialAcademico material) {
        material.setTitulo(request.getTitulo());
        material.setDescripcion(request.getDescripcion());
        material.setTipo(request.getTipo());
        material.setUrl(request.getUrl());
    }

    private MaterialAcademicoDTO aDTO(MaterialAcademico material) {
        return new MaterialAcademicoDTO(material.getId(), material.getTitulo(), material.getDescripcion(),
                material.getTipo(), material.getUrl(), material.getFechaCreacion());
    }
}
