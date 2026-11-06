package com.unicartagena.api_colegio.aplication.service.impl;

import com.unicartagena.api_colegio.aplication.service.IMateriaService;

import com.unicartagena.api_colegio.aplication.dto.MateriasDTO;
import com.unicartagena.api_colegio.aplication.entities.Materias;
import com.unicartagena.api_colegio.aplication.repositories.MateriasRepository;
import com.unicartagena.api_colegio.aplication.request.CrearMateriaRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MateriaServiceImpl implements IMateriaService {

    private final MateriasRepository materiasRepository;

    @Override
    @Transactional(readOnly = true)
    public List<MateriasDTO> listarTodos() {
        return materiasRepository.findAll().stream().map(this::convertirADTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public MateriasDTO buscarPorId(Long id) {
        return convertirADTO(obtenerEntidad(id));
    }

    @Override
    @Transactional
    public MateriasDTO crear(CrearMateriaRequest request) {
        if (materiasRepository.findByCodigo(request.getCodigo()).isPresent()) {
            throw new IllegalArgumentException("Ya existe una materia con el código " + request.getCodigo());
        }
        if (materiasRepository.findByNombre(request.getNombre()).isPresent()) {
            throw new IllegalArgumentException("Ya existe una materia con el nombre " + request.getNombre());
        }
        Materias materia = new Materias();
        copiarDatos(materia, request);
        return convertirADTO(materiasRepository.save(materia));
    }

    @Override
    @Transactional
    public MateriasDTO actualizar(Long id, CrearMateriaRequest request) {
        Materias materia = obtenerEntidad(id);
        materiasRepository.findByCodigo(request.getCodigo()).ifPresent(otra -> {
            if (!otra.getId().equals(id)) {
                throw new IllegalArgumentException("Ya existe una materia con el código " + request.getCodigo());
            }
        });
        materiasRepository.findByNombre(request.getNombre()).ifPresent(otra -> {
            if (!otra.getId().equals(id)) {
                throw new IllegalArgumentException("Ya existe una materia con el nombre " + request.getNombre());
            }
        });
        copiarDatos(materia, request);
        return convertirADTO(materiasRepository.save(materia));
    }

    @Override
    @Transactional
    public void eliminarPorId(Long id) {
        materiasRepository.delete(obtenerEntidad(id));
    }

    private Materias obtenerEntidad(Long id) {
        return materiasRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Materia no encontrada con id " + id));
    }

    private void copiarDatos(Materias materia, CrearMateriaRequest request) {
        materia.setCodigo(request.getCodigo());
        materia.setNombre(request.getNombre());
        materia.setDescripcion(request.getDescripcion());
    }

    private MateriasDTO convertirADTO(Materias materia) {
        return new MateriasDTO(materia.getId(), materia.getCodigo(), materia.getNombre(), materia.getDescripcion());
    }
}
