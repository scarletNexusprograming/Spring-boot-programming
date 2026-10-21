package com.unicartagena.api_colegio.aplication.service.impl;

import com.unicartagena.api_colegio.aplication.base.exceptions.NotFoundException;
import com.unicartagena.api_colegio.aplication.base.exceptions.NotFoundException;
import com.unicartagena.api_colegio.aplication.dto.EstudiantesDTO;
import com.unicartagena.api_colegio.aplication.entities.Estudiantes;
import com.unicartagena.api_colegio.aplication.repositories.EstudiantesRepository;
import com.unicartagena.api_colegio.aplication.request.CrearEstudianteRequest;
import com.unicartagena.api_colegio.aplication.service.IEstudianteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstudianteService implements IEstudianteService {

    // Inyección de dependencias por constructor (lo genera Lombok)
    private final EstudiantesRepository estudiantesRepository;
    private final ModelMapper modelMapper;

    // LISTAR: trae todas las entidades y convierte cada una a DTO
    @Override
    public List<EstudiantesDTO> listarTodos() {
        return estudiantesRepository.findAll()
                .stream()
                .map(estudiante -> modelMapper.map(estudiante, EstudiantesDTO.class))
                .toList();
    }

    // BUSCAR: findById devuelve un Optional; si está vacío lanzamos NotFound
    @Override
    public EstudiantesDTO buscarPorId(Long id) {
        Estudiantes estudiante = estudiantesRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        "No se encontró el estudiante con id: " + id));

        return modelMapper.map(estudiante, EstudiantesDTO.class);
    }

    // CREAR: no se permite repetir la identificación (columna UNIQUE)
    @Override
    @Transactional(rollbackOn = Exception.class)
    public EstudiantesDTO crear(CrearEstudianteRequest request) {

        Optional<Estudiantes> existente = estudiantesRepository
                .findByIdentificacion(request.getIdentificacion());

        if (existente.isPresent()) {
            throw new NotFoundException("Error: el usuario ya se encuentra registrado con su identificación "
                    + request.getIdentificacion());
        }

        Estudiantes nuevo = new Estudiantes();
        nuevo.setNombre(request.getNombre());
        nuevo.setApellido(request.getApellido());
        nuevo.setIdentificacion(request.getIdentificacion());
        nuevo.setCorreo(request.getCorreo());
        nuevo.setEdad(request.getEdad());

        Estudiantes guardado = estudiantesRepository.save(nuevo);

        return modelMapper.map(guardado, EstudiantesDTO.class);
    }

    // ACTUALIZAR: el estudiante debe existir, y la nueva identificación
    // no puede pertenecer a OTRO estudiante
    @Override
    @Transactional(rollbackOn = Exception.class)
    public EstudiantesDTO actualizar(Long id, CrearEstudianteRequest request) {

        Estudiantes estudiante = estudiantesRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        "No se encontró el estudiante con id: " + id));

        Optional<Estudiantes> conMismaIdentificacion = estudiantesRepository
                .findByIdentificacion(request.getIdentificacion());

        if (conMismaIdentificacion.isPresent()
                && !conMismaIdentificacion.get().getId().equals(id)) {
            throw new NotFoundException("Error: la identificación "
                    + request.getIdentificacion() + " ya pertenece a otro estudiante");
        }

        estudiante.setNombre(request.getNombre());
        estudiante.setApellido(request.getApellido());
        estudiante.setIdentificacion(request.getIdentificacion());
        estudiante.setCorreo(request.getCorreo());
        estudiante.setEdad(request.getEdad());

        Estudiantes actualizado = estudiantesRepository.save(estudiante);

        return modelMapper.map(actualizado, EstudiantesDTO.class);
    }

    // ELIMINAR: verifica que exista para responder con un error claro
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void eliminarPorId(Long id) {
        if (!estudiantesRepository.existsById(id)) {
            throw new NotFoundException("No se encontró el estudiante con id: " + id);
        }
        estudiantesRepository.deleteById(id);
    }
}