package com.unicartagena.api_colegio.aplication.service.impl;

import com.unicartagena.api_colegio.aplication.dtos.MatriculaDTO;
import com.unicartagena.api_colegio.aplication.entities.Estudiantes;
import com.unicartagena.api_colegio.aplication.entities.Grados;
import com.unicartagena.api_colegio.aplication.entities.Matricula;
import com.unicartagena.api_colegio.aplication.repositories.MatriculaRepository;
import com.unicartagena.api_colegio.aplication.request.CrearMatriculaRequest;
import com.unicartagena.api_colegio.aplication.service.IMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatriculaService implements IMatriculaService {

    private final MatriculaRepository matriculaRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MatriculaDTO create(CrearMatriculaRequest crearMatriculaRequest) {

        // Creamos referencias "livianas" a Estudiante y Grado, solo con el id
        // que llega en el request (JPA las resuelve al guardar en la BD).
        Estudiantes estudiante = new Estudiantes();
        estudiante.setId(crearMatriculaRequest.getEstudianteId());

        Grados grado = new Grados();
        grado.setId(crearMatriculaRequest.getGradoId());

        Matricula nuevaMatricula = new Matricula(
                estudiante,
                grado,
                crearMatriculaRequest.getFechaMatricula(),
                crearMatriculaRequest.getPeriodoAcademico(),
                "ACTIVA"
        );

        Matricula guardada = matriculaRepository.save(nuevaMatricula);

        return mapToDTO(guardada);
    }

    @Override
    public List<MatriculaDTO> findAll() {
        return matriculaRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private MatriculaDTO mapToDTO(Matricula matricula) {
        return new MatriculaDTO(
                matricula.getId(),
                matricula.getEstudiante().getId(),
                matricula.getEstudiante().getNombre(),
                matricula.getGrado().getId(),
                matricula.getGrado().getNombre(),
                matricula.getFechaMatricula(),
                matricula.getPeriodoAcademico(),
                matricula.getEstado()
        );
    }
}