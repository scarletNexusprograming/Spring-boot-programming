package com.unicartagena.api_colegio.aplication.service.impl;

import com.unicartagena.api_colegio.aplication.service.IGradoService;

import com.unicartagena.api_colegio.aplication.dto.GradosDTO;
import com.unicartagena.api_colegio.aplication.entities.Grados;
import com.unicartagena.api_colegio.aplication.repositories.GradosRepository;
import com.unicartagena.api_colegio.aplication.request.CrearGradoRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradoServiceImpl implements IGradoService {

    private final GradosRepository gradosRepository;

    @Override
    @Transactional(readOnly = true)
    public List<GradosDTO> listarTodos() {
        return gradosRepository.findAll().stream().map(this::convertirADTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public GradosDTO buscarPorId(Long id) {
        return convertirADTO(obtenerEntidad(id));
    }

    @Override
    @Transactional
    public GradosDTO crear(CrearGradoRequest request) {
        if (gradosRepository.findByNombre(request.getNombre()).isPresent()) {
            throw new IllegalArgumentException("Ya existe un grado con el nombre " + request.getNombre());
        }
        Grados grado = new Grados();
        copiarDatos(grado, request);
        return convertirADTO(gradosRepository.save(grado));
    }

    @Override
    @Transactional
    public GradosDTO actualizar(Long id, CrearGradoRequest request) {
        Grados grado = obtenerEntidad(id);
        gradosRepository.findByNombre(request.getNombre()).ifPresent(otro -> {
            if (!otro.getId().equals(id)) {
                throw new IllegalArgumentException("Ya existe un grado con el nombre " + request.getNombre());
            }
        });
        copiarDatos(grado, request);
        return convertirADTO(gradosRepository.save(grado));
    }

    @Override
    @Transactional
    public void eliminarPorId(Long id) {
        gradosRepository.delete(obtenerEntidad(id));
    }

    private Grados obtenerEntidad(Long id) {
        return gradosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Grado no encontrado con id " + id));
    }

    private void copiarDatos(Grados grado, CrearGradoRequest request) {
        grado.setNombre(request.getNombre());
        grado.setNivel(request.getNivel());
    }

    private GradosDTO convertirADTO(Grados grado) {
        return new GradosDTO(grado.getId(), grado.getNombre(), grado.getNivel());
    }
}
