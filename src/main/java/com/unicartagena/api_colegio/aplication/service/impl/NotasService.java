package com.unicartagena.api_colegio.aplication.service.impl;

import com.unicartagena.api_colegio.aplication.dto.NotasDTO;
import com.unicartagena.api_colegio.aplication.entities.Notas;
import com.unicartagena.api_colegio.aplication.repositories.NotasRepository;
import com.unicartagena.api_colegio.aplication.request.CrearNotaRequest;
import com.unicartagena.api_colegio.aplication.service.INotasService;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class NotasService implements INotasService {

    private final NotasRepository notasRepository;
    private final ModelMapper modelMapper;

    @Override
    public NotasDTO crear(CrearNotaRequest request) {

        Notas nota = new Notas();

        nota.setValor(request.getValor());
        nota.setPeriodo(request.getPeriodo());
        nota.setTipoEvaluacion(request.getTipoEvaluacion());
        nota.setObservacion(request.getObservacion());
        nota.setEstudianteId(request.getEstudianteId());
        nota.setMateriaId(request.getMateriaId());

        Notas notaGuardada = notasRepository.save(nota);

        return modelMapper.map(notaGuardada, NotasDTO.class);
    }

    @Override
    public List<NotasDTO> listarTodas() {

        return notasRepository.findAll().stream()
                .map(nota -> modelMapper.map(nota, NotasDTO.class))
                .toList();
    }

    @Override
    public NotasDTO buscarPorId(Long id) {

        Notas nota = notasRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "No se encontró la nota con ID: " + id
                ));

        return modelMapper.map(nota, NotasDTO.class);
    }

    @Override
    public List<NotasDTO> buscarPorEstudiante(Long estudianteId) {

        return notasRepository.findByEstudianteId(estudianteId).stream()
                .map(nota -> modelMapper.map(nota, NotasDTO.class))
                .toList();
    }

    @Override
    public List<NotasDTO> buscarPorMateria(Long materiaId) {

        return notasRepository.findByMateriaId(materiaId).stream()
                .map(nota -> modelMapper.map(nota, NotasDTO.class))
                .toList();
    }

    @Override
    public List<NotasDTO> buscarPorPeriodo(Integer periodo) {

        return notasRepository.findByPeriodo(periodo).stream()
                .map(nota -> modelMapper.map(nota, NotasDTO.class))
                .toList();
    }

    @Override
    public List<NotasDTO> buscarPorEstudianteYMateria(
            Long estudianteId,
            Long materiaId) {

        return notasRepository.findByEstudianteIdAndMateriaId(
                        estudianteId,
                        materiaId
                ).stream()
                .map(nota -> modelMapper.map(nota, NotasDTO.class))
                .toList();
    }

    @Override
    public NotasDTO actualizar(Long id, CrearNotaRequest request) {

        Notas nota = notasRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "No se encontró la nota con ID: " + id
                ));

        nota.setValor(request.getValor());
        nota.setPeriodo(request.getPeriodo());
        nota.setTipoEvaluacion(request.getTipoEvaluacion());
        nota.setObservacion(request.getObservacion());
        nota.setEstudianteId(request.getEstudianteId());
        nota.setMateriaId(request.getMateriaId());

        Notas notaActualizada = notasRepository.save(nota);

        return modelMapper.map(notaActualizada, NotasDTO.class);
    }

    @Override
    public void eliminarPorId(Long id) {

        Notas nota = notasRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "No se encontró la nota con ID: " + id
                ));

        notasRepository.delete(nota);
    }
}