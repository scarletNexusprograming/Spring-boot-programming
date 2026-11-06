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

import com.unicartagena.api_colegio.aplication.dto.MaterialAcademicoDTO;
import com.unicartagena.api_colegio.aplication.request.CrearMaterialAcademicoRequest;
import com.unicartagena.api_colegio.aplication.service.IMaterialAcademicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/material-academico")
@RequiredArgsConstructor
public class MaterialAcademicoController {

    private final IMaterialAcademicoService materialAcademicoService;

    @PostMapping
    public ResponseEntity<MaterialAcademicoDTO> crear(@Valid @RequestBody CrearMaterialAcademicoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(materialAcademicoService.crear(request));
    }

    @GetMapping
    public ResponseEntity<List<MaterialAcademicoDTO>> listar() {
        return ResponseEntity.ok(materialAcademicoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialAcademicoDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(materialAcademicoService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterialAcademicoDTO> actualizar(@PathVariable Long id, @Valid @RequestBody CrearMaterialAcademicoRequest request) {
        return ResponseEntity.ok(materialAcademicoService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        materialAcademicoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
