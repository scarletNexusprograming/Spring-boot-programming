package com.unicartagena.api_colegio.aplication.controller;

import com.unicartagena.api_colegio.aplication.base.utils.ResponseDTOService;
import com.unicartagena.api_colegio.aplication.dto.NotasDTO;
import com.unicartagena.api_colegio.aplication.request.CrearNotaRequest;
import com.unicartagena.api_colegio.aplication.service.INotasService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notas")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class NotasController {

    private final INotasService notasService;
    private final ResponseDTOService responseDTOService;

    @GetMapping
    public ResponseEntity<?> listarTodas() {

        List<NotasDTO> notas = notasService.listarTodas();

        return responseDTOService.response(
                HttpStatus.OK,
                "Notas obtenidas exitosamente",
                notas
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {

        NotasDTO nota = notasService.buscarPorId(id);

        return responseDTOService.response(
                HttpStatus.OK,
                "Nota encontrada correctamente",
                nota
        );
    }

    @GetMapping("/estudiante/{estudianteId}")
    public ResponseEntity<?> buscarPorEstudiante(
            @PathVariable Long estudianteId) {

        List<NotasDTO> notas =
                notasService.buscarPorEstudiante(estudianteId);

        return responseDTOService.response(
                HttpStatus.OK,
                "Notas del estudiante obtenidas exitosamente",
                notas
        );
    }

    @GetMapping("/materia/{materiaId}")
    public ResponseEntity<?> buscarPorMateria(
            @PathVariable Long materiaId) {

        List<NotasDTO> notas =
                notasService.buscarPorMateria(materiaId);

        return responseDTOService.response(
                HttpStatus.OK,
                "Notas de la materia obtenidas exitosamente",
                notas
        );
    }

    @GetMapping("/periodo/{periodo}")
    public ResponseEntity<?> buscarPorPeriodo(
            @PathVariable Integer periodo) {

        List<NotasDTO> notas =
                notasService.buscarPorPeriodo(periodo);

        return responseDTOService.response(
                HttpStatus.OK,
                "Notas del periodo obtenidas exitosamente",
                notas
        );
    }

    @GetMapping("/estudiante/{estudianteId}/materia/{materiaId}")
    public ResponseEntity<?> buscarPorEstudianteYMateria(
            @PathVariable Long estudianteId,
            @PathVariable Long materiaId) {

        List<NotasDTO> notas =
                notasService.buscarPorEstudianteYMateria(
                        estudianteId,
                        materiaId
                );

        return responseDTOService.response(
                HttpStatus.OK,
                "Notas del estudiante en la materia obtenidas exitosamente",
                notas
        );
    }

    @PostMapping
    public ResponseEntity<?> crear(
            @Valid @RequestBody CrearNotaRequest request) {

        NotasDTO nota = notasService.crear(request);

        return responseDTOService.response(
                HttpStatus.CREATED,
                "Nota creada exitosamente",
                nota
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody CrearNotaRequest request) {

        NotasDTO nota = notasService.actualizar(id, request);

        return responseDTOService.response(
                HttpStatus.OK,
                "Nota actualizada correctamente",
                nota
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable Long id) {

        notasService.eliminarPorId(id);

        return responseDTOService.response(
                HttpStatus.OK,
                "Nota eliminada con éxito"
        );
    }
}