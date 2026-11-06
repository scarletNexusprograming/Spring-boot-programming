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

import com.unicartagena.api_colegio.aplication.dto.RolesDTO;
import com.unicartagena.api_colegio.aplication.request.CrearRolRequest;
import com.unicartagena.api_colegio.aplication.service.IRolService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RolesController {

    private final IRolService rolService;

    @PostMapping
    public ResponseEntity<RolesDTO> crear(@Valid @RequestBody CrearRolRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rolService.crear(request));
    }

    @GetMapping
    public ResponseEntity<List<RolesDTO>> listar() {
        return ResponseEntity.ok(rolService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolesDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(rolService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolesDTO> actualizar(@PathVariable Long id, @Valid @RequestBody CrearRolRequest request) {
        return ResponseEntity.ok(rolService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        rolService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
