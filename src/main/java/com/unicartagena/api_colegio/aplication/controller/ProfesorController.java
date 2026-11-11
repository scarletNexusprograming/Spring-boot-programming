package com.unicartagena.api_colegio.aplication.controller;

import com.unicartagena.api_colegio.aplication.base.utils.ResponseDTOService;
import com.unicartagena.api_colegio.aplication.dto.ProfesoresDTO;
import com.unicartagena.api_colegio.aplication.request.CrearProfesorRequest;
import com.unicartagena.api_colegio.aplication.service.IProfesorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/profesores")
@RequiredArgsConstructor
public class ProfesorController {

    private final ResponseDTOService responseDTOService;
    private final IProfesorService profesorService;

    // Lista todos los profesores
    @GetMapping
    public ResponseEntity<?> listar() {
        List<ProfesoresDTO> profesores = profesorService.listarTodos();
        return responseDTOService.response(HttpStatus.OK, "Profesores obtenidos exitosamente", profesores);
    }

    // Busca un profesor por id
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        ProfesoresDTO profesor = profesorService.buscarPorId(id);
        return responseDTOService.response(HttpStatus.OK, "Profesor encontrado correctamente", profesor);
    }

    // Crea un profesor nuevo
    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody CrearProfesorRequest request) {
        ProfesoresDTO nuevo = profesorService.crear(request);
        return responseDTOService.response(HttpStatus.CREATED, "Profesor creado exitosamente", nuevo);
    }

    // Actualiza un profesor por id
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPorId(@PathVariable Long id, @Valid @RequestBody CrearProfesorRequest request) {
        ProfesoresDTO profesor = profesorService.actualizar(id, request);
        return responseDTOService.response(HttpStatus.OK, "Profesor actualizado correctamente", profesor);
    }

    // Elimina un profesor por id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable Long id) {
        profesorService.eliminarPorId(id);
        return responseDTOService.response(HttpStatus.OK, "Profesor eliminado con éxito", null);
    }
}
