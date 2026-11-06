package com.unicartagena.api_colegio.aplication.service;

import com.unicartagena.api_colegio.aplication.dto.ProfesoresDTO;
import com.unicartagena.api_colegio.aplication.entities.Profesores;
import com.unicartagena.api_colegio.aplication.repositories.ProfesoresRepository;
import com.unicartagena.api_colegio.aplication.request.CrearProfesorRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfesorServiceImpl implements IProfesorService {

    private final ProfesoresRepository profesoresRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProfesoresDTO> listarTodos() {
        return profesoresRepository.findAll().stream().map(this::convertirADTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ProfesoresDTO buscarPorId(Long id) {
        return convertirADTO(obtenerEntidad(id));
    }

    @Override
    @Transactional
    public ProfesoresDTO crear(CrearProfesorRequest request) {
        if (profesoresRepository.findByIdentificacion(request.getIdentificacion()).isPresent()) {
            throw new IllegalArgumentException("Ya existe un profesor con la identificación " + request.getIdentificacion());
        }
        Profesores profesor = new Profesores();
        copiarDatos(profesor, request);
        return convertirADTO(profesoresRepository.save(profesor));
    }

    @Override
    @Transactional
    public ProfesoresDTO actualizar(Long id, CrearProfesorRequest request) {
        Profesores profesor = obtenerEntidad(id);
        profesoresRepository.findByIdentificacion(request.getIdentificacion()).ifPresent(otro -> {
            if (!otro.getId().equals(id)) {
                throw new IllegalArgumentException("Ya existe un profesor con la identificación " + request.getIdentificacion());
            }
        });
        copiarDatos(profesor, request);
        return convertirADTO(profesoresRepository.save(profesor));
    }

    @Override
    @Transactional
    public void eliminarPorId(Long id) {
        profesoresRepository.delete(obtenerEntidad(id));
    }

    private Profesores obtenerEntidad(Long id) {
        return profesoresRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profesor no encontrado con id " + id));
    }

    private void copiarDatos(Profesores profesor, CrearProfesorRequest request) {
        profesor.setNombre(request.getNombre());
        profesor.setApellido(request.getApellido());
        profesor.setIdentificacion(request.getIdentificacion());
        profesor.setCorreo(request.getCorreo());
        profesor.setTelefono(request.getTelefono());
        profesor.setEspecialidad(request.getEspecialidad());
    }

    private ProfesoresDTO convertirADTO(Profesores profesor) {
        return new ProfesoresDTO(profesor.getId(), profesor.getNombre(), profesor.getApellido(),
                profesor.getIdentificacion(), profesor.getCorreo(), profesor.getTelefono(),
                profesor.getEspecialidad());
    }
}
