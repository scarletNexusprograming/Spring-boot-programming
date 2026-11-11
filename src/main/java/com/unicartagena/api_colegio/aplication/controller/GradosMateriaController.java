package com.unicartagena.api_colegio.aplication.controller;

import com.unicartagena.api_colegio.aplication.base.utils.ResponseDTOService;
import com.unicartagena.api_colegio.aplication.dto.GradosMateriasDTO;
import com.unicartagena.api_colegio.aplication.request.CrearGradoMateriaRequest;
import com.unicartagena.api_colegio.aplication.service.IGradoMateriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/grados-materias")
@RequiredArgsConstructor
public class GradosMateriaController {

    private final ResponseDTOService responseDTOService;
    private final IGradoMateriaService gradoMateriaService;

    // Lista todas las asignaciones grado-materia
    @GetMapping
    public ResponseEntity<?> listar() {
        List<GradosMateriasDTO> lista = gradoMateriaService.listarTodos();
        return responseDTOService.response(HttpStatus.OK, "Asignaciones obtenidas exitosamente", lista);
    }

    // Busca una asignación por id
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        GradosMateriasDTO gradoMateria = gradoMateriaService.buscarPorId(id);
        return responseDTOService.response(HttpStatus.OK, "Asignación encontrada correctamente", gradoMateria);
    }

    // Crea una asignación nueva
    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody CrearGradoMateriaRequest request) {
        GradosMateriasDTO nueva = gradoMateriaService.crear(request);
        return responseDTOService.response(HttpStatus.CREATED, "Asignación creada exitosamente", nueva);
    }

    // Actualiza una asignación por id
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPorId(@PathVariable Long id, @Valid @RequestBody CrearGradoMateriaRequest request) {
        GradosMateriasDTO gradoMateria = gradoMateriaService.actualizar(id, request);
        return responseDTOService.response(HttpStatus.OK, "Asignación actualizada correctamente", gradoMateria);
    }

    // Elimina una asignación por id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable Long id) {
        gradoMateriaService.eliminarPorId(id);
        return responseDTOService.response(HttpStatus.OK, "Asignación eliminada con éxito", null);
    }
}
