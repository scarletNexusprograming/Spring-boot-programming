
package com.unicartagena.api_colegio.aplication.service.impl;

import com.unicartagena.api_colegio.aplication.dto.UsuariosDTO;
import com.unicartagena.api_colegio.aplication.entities.Usuarios;
import com.unicartagena.api_colegio.aplication.repositories.UsuariosRepository;
import com.unicartagena.api_colegio.aplication.request.CrearUsuarioRequest;
import com.unicartagena.api_colegio.aplication.service.IUsuarioService;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {

    private final UsuariosRepository usuariosRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UsuariosDTO crear(CrearUsuarioRequest request) {

        if (usuariosRepository.findByCorreo(request.getCorreo()).isPresent()) {
            throw new IllegalArgumentException("El correo ya está registrado");
        }

        Usuarios usuario = new Usuarios();

        usuario.setNombre(request.getNombre());
        usuario.setApellido(request.getApellido());
        usuario.setCorreo(request.getCorreo());
        usuario.setContrasena(passwordEncoder.encode(request.getContrasena()));
        usuario.setEstado(true);

        Usuarios usuarioGuardado = usuariosRepository.save(usuario);

        return modelMapper.map(usuarioGuardado, UsuariosDTO.class);
    }

    @Override
    public List<UsuariosDTO> listarTodos() {

        return usuariosRepository.findAll()
                .stream()
                .map(usuario -> modelMapper.map(usuario, UsuariosDTO.class))
                .toList();
    }

    @Override
    public UsuariosDTO buscarPorId(Long id) {

        Usuarios usuario = usuariosRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("No se encontró el usuario con ID: " + id));

        return modelMapper.map(usuario, UsuariosDTO.class);
    }

    @Override
    public UsuariosDTO buscarPorNombre(String nombre) {

        Usuarios usuario = usuariosRepository.findByNombre(nombre)
                .orElseThrow(() ->
                        new NoSuchElementException("No se encontró el usuario con ese nombre"));

        return modelMapper.map(usuario, UsuariosDTO.class);
    }

    @Override
    public UsuariosDTO buscarPorApellido(String apellido) {

        Usuarios usuario = usuariosRepository.findByApellido(apellido)
                .orElseThrow(() ->
                        new NoSuchElementException("No se encontró el usuario con ese apellido"));

        return modelMapper.map(usuario, UsuariosDTO.class);
    }

    @Override
    public UsuariosDTO buscarPorCorreo(String correo) {

        Usuarios usuario = usuariosRepository.findByCorreo(correo)
                .orElseThrow(() ->
                        new NoSuchElementException("No se encontró el usuario con ese correo"));

        return modelMapper.map(usuario, UsuariosDTO.class);
    }

    @Override
    public UsuariosDTO actualizar(Long id, CrearUsuarioRequest request) {

        Usuarios usuario = usuariosRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("No se encontró el usuario con ID: " + id));

        usuariosRepository.findByCorreo(request.getCorreo())
                .filter(otroUsuario -> !otroUsuario.getId().equals(id))
                .ifPresent(otroUsuario -> {
                    throw new IllegalArgumentException("El correo ya está registrado");
                });

        usuario.setNombre(request.getNombre());
        usuario.setApellido(request.getApellido());
        usuario.setCorreo(request.getCorreo());
        usuario.setContrasena(passwordEncoder.encode(request.getContrasena()));

        Usuarios usuarioActualizado = usuariosRepository.save(usuario);

        return modelMapper.map(usuarioActualizado, UsuariosDTO.class);
    }

    @Override
    public void eliminarPorId(Long id) {

        Usuarios usuario = usuariosRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("No se encontró el usuario con ID: " + id));

        usuariosRepository.delete(usuario);
    }
}
