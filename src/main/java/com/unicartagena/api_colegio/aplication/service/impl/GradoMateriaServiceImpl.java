package com.unicartagena.api_colegio.aplication.service;

import com.unicartagena.api_colegio.aplication.dto.GradosMateriasDTO;
import com.unicartagena.api_colegio.aplication.entities.GradosMaterias;
import com.unicartagena.api_colegio.aplication.repositories.GradosMateriasRepository;
import com.unicartagena.api_colegio.aplication.request.CrearGradoMateriaRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradoMateriaServiceImpl implements IGradoMateriaService {

    private final GradosMateriasRepository gradosMateriasRepository;

    @Override
    @Transactional(readOnly = true)
    public List<GradosMateriasDTO> listarTodos() {
        return gradosMateriasRepository.findAll().stream().map(this::convertirADTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public GradosMateriasDTO buscarPorId(Long id) {
        return convertirADTO(obtenerEntidad(id));
    }

    @Override
    @Transactional
    public GradosMateriasDTO crear(CrearGradoMateriaRequest request) {
        GradosMaterias gradoMateria = new GradosMaterias();
        gradoMateria.setHorasSemanales(request.getHorasSemanales());
        return convertirADTO(gradosMateriasRepository.save(gradoMateria));
    }

    @Override
    @Transactional
    public GradosMateriasDTO actualizar(Long id, CrearGradoMateriaRequest request) {
        GradosMaterias gradoMateria = obtenerEntidad(id);
        gradoMateria.setHorasSemanales(request.getHorasSemanales());
        return convertirADTO(gradosMateriasRepository.save(gradoMateria));
    }

    @Override
    @Transactional
    public void eliminarPorId(Long id) {
        gradosMateriasRepository.delete(obtenerEntidad(id));
    }

    private GradosMaterias obtenerEntidad(Long id) {
        return gradosMateriasRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Asignación grado-materia no encontrada con id " + id));
    }

    private GradosMateriasDTO convertirADTO(GradosMaterias gradoMateria) {
        return new GradosMateriasDTO(gradoMateria.getId(), gradoMateria.getHorasSemanales());
    }
}
