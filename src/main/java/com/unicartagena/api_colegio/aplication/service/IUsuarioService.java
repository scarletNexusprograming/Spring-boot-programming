
package com.unicartagena.api_colegio.aplication.service;

import com.unicartagena.api_colegio.aplication.dto.UsuariosDTO;
import com.unicartagena.api_colegio.aplication.request.CrearUsuarioRequest;

import java.util.List;

public interface IUsuarioService {

    UsuariosDTO crear(CrearUsuarioRequest request);

    List<UsuariosDTO> listarTodos();

    UsuariosDTO buscarPorId(Long id);

    UsuariosDTO buscarPorNombre(String nombre);

    UsuariosDTO buscarPorApellido(String apellido);

    UsuariosDTO buscarPorCorreo(String correo);

    UsuariosDTO actualizar(Long id, CrearUsuarioRequest request);

    void eliminarPorId(Long id);
}
