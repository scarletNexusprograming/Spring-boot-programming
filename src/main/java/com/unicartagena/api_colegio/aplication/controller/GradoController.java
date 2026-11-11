package com.unicartagena.api_colegio.aplication.controller;

import com.unicartagena.api_colegio.aplication.base.utils.ResponseDTOService;
import com.unicartagena.api_colegio.aplication.dto.GradosDTO;
import com.unicartagena.api_colegio.aplication.request.CrearGradoRequest;
import com.unicartagena.api_colegio.aplication.service.IGradoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/grados")
@RequiredArgsConstructor
public class GradoController {

    private final ResponseDTOService responseDTOService;
    private final IGradoService gradoService;

    // Lista todos los grados
    @GetMapping
    public ResponseEntity<?> listar() {
        List<GradosDTO> grados = gradoService.listarTodos();
        return responseDTOService.response(HttpStatus.OK, "Grados obtenidos exitosamente", grados);
    }

    // Busca un grado por id
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        GradosDTO grado = gradoService.buscarPorId(id);
        return responseDTOService.response(HttpStatus.OK, "Grado encontrado correctamente", grado);
    }

    // Crea un grado nuevo
    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody CrearGradoRequest request) {
        GradosDTO nuevo = gradoService.crear(request);
        return responseDTOService.response(HttpStatus.CREATED, "Grado creado exitosamente", nuevo);
    }

    // Actualiza un grado por id
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPorId(@PathVariable Long id, @Valid @RequestBody CrearGradoRequest request) {
        GradosDTO grado = gradoService.actualizar(id, request);
        return responseDTOService.response(HttpStatus.OK, "Grado actualizado correctamente", grado);
    }

    // Elimina un grado por id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable Long id) {
        gradoService.eliminarPorId(id);
        return responseDTOService.response(HttpStatus.OK, "Grado eliminado con éxito", null);
    }
}
