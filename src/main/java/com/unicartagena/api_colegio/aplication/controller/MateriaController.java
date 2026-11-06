package com.unicartagena.api_colegio.aplication.controller;

import com.unicartagena.api_colegio.aplication.base.utils.ResponseDTOService;
import com.unicartagena.api_colegio.aplication.dto.MateriasDTO;
import com.unicartagena.api_colegio.aplication.request.CrearMateriaRequest;
import com.unicartagena.api_colegio.aplication.service.IMateriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/materias")
@RequiredArgsConstructor
public class MateriaController {

    private final ResponseDTOService responseDTOService;
    private final IMateriaService materiaService;

    // Lista todas las materias
    @GetMapping
    public ResponseEntity<?> listar() {
        List<MateriasDTO> materias = materiaService.listarTodos();
        return responseDTOService.response(HttpStatus.OK, "Materias obtenidas exitosamente", materias);
    }

    // Busca una materia por id
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        MateriasDTO materia = materiaService.buscarPorId(id);
        return responseDTOService.response(HttpStatus.OK, "Materia encontrada correctamente", materia);
    }

    // Crea una materia nueva
    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody CrearMateriaRequest request) {
        MateriasDTO nueva = materiaService.crear(request);
        return responseDTOService.response(HttpStatus.CREATED, "Materia creada exitosamente", nueva);
    }

    // Actualiza una materia por id
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPorId(@PathVariable Long id, @Valid @RequestBody CrearMateriaRequest request) {
        MateriasDTO materia = materiaService.actualizar(id, request);
        return responseDTOService.response(HttpStatus.OK, "Materia actualizada correctamente", materia);
    }

    // Elimina una materia por id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable Long id) {
        materiaService.eliminarPorId(id);
        return responseDTOService.response(HttpStatus.OK, "Materia eliminada con éxito", null);
    }
}
