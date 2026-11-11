package com.unicartagena.api_colegio.aplication.controller;

import com.unicartagena.api_colegio.aplication.base.utils.ResponseDTOService;
import com.unicartagena.api_colegio.aplication.dto.EstudiantesDTO;
import com.unicartagena.api_colegio.aplication.request.CrearEstudianteRequest;
import com.unicartagena.api_colegio.aplication.service.IEstudianteService; // #10 ajusta la ruta si tu interfaz está en otro paquete
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List; // #2

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/estudiantes") // #1
@RequiredArgsConstructor
public class EstudianteController {

    private final ResponseDTOService responseDTOService;
    private final IEstudianteService estudianteService; // #10

    // Lista todos los estudiantes
    @GetMapping
    public ResponseEntity<?> listar() {
        List<EstudiantesDTO> estudiantes = estudianteService.listarTodos();
        return responseDTOService.response(HttpStatus.OK, "Estudiantes obtenidos exitosamente", (EstudiantesDTO) estudiantes); // #6
    }

    // Busca un estudiante por id
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) { // #11, #12
        EstudiantesDTO estudiante = estudianteService.buscarPorId(id);
        return responseDTOService.response(HttpStatus.OK, "Estudiante encontrado correctamente", estudiante); // #3
    }

    // Crea un estudiante nuevo
    @PostMapping // #8
    public ResponseEntity<?> crear(@Valid @RequestBody CrearEstudianteRequest request) {
        EstudiantesDTO nuevo = estudianteService.crear(request);
        return responseDTOService.response(HttpStatus.CREATED, "Estudiante creado exitosamente", nuevo);
    }

    // Actualiza un estudiante por id
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPorId(@PathVariable Long id, @Valid @RequestBody CrearEstudianteRequest request) {
        EstudiantesDTO estudiante = estudianteService.actualizar(id, request); // #4
        return responseDTOService.response(HttpStatus.OK, "Estudiante actualizado correctamente", estudiante); // #7
    }

    // Elimina un estudiante por id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable Long id) {
        estudianteService.eliminarPorId(id); // #5
        return responseDTOService.response(HttpStatus.OK, "Estudiante eliminado con éxito", null); // #9
    }
}