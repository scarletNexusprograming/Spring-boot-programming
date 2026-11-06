package com.unicartagena.api_colegio.aplication.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.unicartagena.api_colegio.aplication.dto.RolesDTO;
import com.unicartagena.api_colegio.aplication.entities.Roles;
import com.unicartagena.api_colegio.aplication.repositories.RolesRepository;
import com.unicartagena.api_colegio.aplication.request.CrearRolRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RolService implements IRolService {

    private final RolesRepository rolesRepository;

    @Override
    public RolesDTO crear(CrearRolRequest request) {
        if (rolesRepository.findByNombre(request.getNombre()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe un rol con ese nombre");
        }
        Roles rol = new Roles();
        rol.setNombre(request.getNombre());
        rol.setDescripcion(request.getDescripcion());
        return aDTO(rolesRepository.save(rol));
    }

    @Override
    public List<RolesDTO> listar() {
        return rolesRepository.findAll().stream().map(this::aDTO).toList();
    }

    @Override
    public RolesDTO obtenerPorId(Long id) {
        return aDTO(buscar(id));
    }

    @Override
    public RolesDTO actualizar(Long id, CrearRolRequest request) {
        Roles rol = buscar(id);
        rolesRepository.findByNombre(request.getNombre())
                .filter(otro -> !otro.getId().equals(id))
                .ifPresent(otro -> {
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe un rol con ese nombre");
                });
        rol.setNombre(request.getNombre());
        rol.setDescripcion(request.getDescripcion());
        return aDTO(rolesRepository.save(rol));
    }

    @Override
    public void eliminar(Long id) {
        rolesRepository.delete(buscar(id));
    }

    private Roles buscar(Long id) {
        return rolesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rol no encontrado"));
    }

    private RolesDTO aDTO(Roles rol) {
        return new RolesDTO(rol.getId(), rol.getNombre(), rol.getDescripcion());
    }
}
