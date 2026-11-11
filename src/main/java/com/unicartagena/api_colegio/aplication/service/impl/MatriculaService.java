package com.unicartagena.api_colegio.aplication.service.impl;

import com.unicartagena.api_colegio.aplication.service.IMatriculaService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.unicartagena.api_colegio.aplication.dto.MatriculasDTO;
import com.unicartagena.api_colegio.aplication.entities.Matriculas;
import com.unicartagena.api_colegio.aplication.repositories.MatriculasRepository;
import com.unicartagena.api_colegio.aplication.request.CrearMatriculaRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MatriculaService implements IMatriculaService {

    private final MatriculasRepository matriculasRepository;

    @Override
    public MatriculasDTO crear(CrearMatriculaRequest request) {
        Matriculas matricula = new Matriculas();
        copiar(request, matricula);
        return aDTO(matriculasRepository.save(matricula));
    }

    @Override
    public List<MatriculasDTO> listar() {
        return matriculasRepository.findAll().stream().map(this::aDTO).toList();
    }

    @Override
    public MatriculasDTO obtenerPorId(Long id) {
        return aDTO(buscar(id));
    }

    @Override
    public MatriculasDTO actualizar(Long id, CrearMatriculaRequest request) {
        Matriculas matricula = buscar(id);
        copiar(request, matricula);
        return aDTO(matriculasRepository.save(matricula));
    }

    @Override
    public void eliminar(Long id) {
        matriculasRepository.delete(buscar(id));
    }

    private Matriculas buscar(Long id) {
        return matriculasRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Matricula no encontrada"));
    }

    private void copiar(CrearMatriculaRequest request, Matriculas matricula) {
        matricula.setPeriodoAcademico(request.getPeriodoAcademico());
        matricula.setEstado(request.getEstado());
        matricula.setObservaciones(request.getObservaciones());
    }

    private MatriculasDTO aDTO(Matriculas matricula) {
        return new MatriculasDTO(matricula.getId(), matricula.getPeriodoAcademico(), matricula.getEstado(),
                matricula.getObservaciones(), matricula.getFechaMatricula());
    }
}
