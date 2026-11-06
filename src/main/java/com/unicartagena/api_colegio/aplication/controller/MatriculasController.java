package com.unicartagena.api_colegio.aplication.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicartagena.api_colegio.aplication.dto.MatriculasDTO;
import com.unicartagena.api_colegio.aplication.request.CrearMatriculaRequest;
import com.unicartagena.api_colegio.aplication.service.IMatriculaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/matriculas")
@RequiredArgsConstructor
public class MatriculasController {

    private final IMatriculaService matriculaService;

    @PostMapping
    public ResponseEntity<MatriculasDTO> crear(@Valid @RequestBody CrearMatriculaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(matriculaService.crear(request));
    }

    @GetMapping
    public ResponseEntity<List<MatriculasDTO>> listar() {
        return ResponseEntity.ok(matriculaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatriculasDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(matriculaService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatriculasDTO> actualizar(@PathVariable Long id, @Valid @RequestBody CrearMatriculaRequest request) {
        return ResponseEntity.ok(matriculaService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        matriculaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
