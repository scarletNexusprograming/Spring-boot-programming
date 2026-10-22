
package com.unicartagena.api_colegio.aplication.controller;

import com.unicartagena.api_colegio.aplication.dto.UsuariosDTO;
import com.unicartagena.api_colegio.aplication.request.CrearUsuarioRequest;
import com.unicartagena.api_colegio.aplication.service.IUsuarioService;
import com.unicartagena.api_colegio.aplication.base.utils.ResponseDTOService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class UsuariosController {

    private final IUsuarioService usuarioService;
    private final ResponseDTOService responseDTOService;

    @GetMapping
    public ResponseEntity<?> listar() {

        List<UsuariosDTO> usuarios = usuarioService.listarTodos();

        return responseDTOService.response(
                HttpStatus.OK,
                "Usuarios obtenidos exitosamente",
                usuarios
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {

        UsuariosDTO usuario = usuarioService.buscarPorId(id);

        return responseDTOService.response(
                HttpStatus.OK,
                "Usuario encontrado correctamente",
                usuario
        );
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> buscarPorNombre(@PathVariable String nombre) {

        UsuariosDTO usuario = usuarioService.buscarPorNombre(nombre);

        return responseDTOService.response(
                HttpStatus.OK,
                "Usuario encontrado correctamente",
                usuario
        );
    }

    @GetMapping("/apellido/{apellido}")
    public ResponseEntity<?> buscarPorApellido(@PathVariable String apellido) {

        UsuariosDTO usuario = usuarioService.buscarPorApellido(apellido);

        return responseDTOService.response(
                HttpStatus.OK,
                "Usuario encontrado correctamente",
                usuario
        );
    }

    @GetMapping("/correo")
    public ResponseEntity<?> buscarPorCorreo(@RequestParam String correo) {

        UsuariosDTO usuario = usuarioService.buscarPorCorreo(correo);

        return responseDTOService.response(
                HttpStatus.OK,
                "Usuario encontrado correctamente",
                usuario
        );
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody CrearUsuarioRequest request) {

        UsuariosDTO usuario = usuarioService.crear(request);

        return responseDTOService.response(
                HttpStatus.CREATED,
                "Usuario creado exitosamente",
                usuario
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody CrearUsuarioRequest request) {

        UsuariosDTO usuario = usuarioService.actualizar(id, request);

        return responseDTOService.response(
                HttpStatus.OK,
                "Usuario actualizado correctamente",
                usuario
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable Long id) {

        usuarioService.eliminarPorId(id);

        return responseDTOService.response(
                HttpStatus.OK,
                "Usuario eliminado con éxito"
        );
    }
}
