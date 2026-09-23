package com.unicartagena.api_colegio.aplication.service.impl;

import com.unicartagena.api_colegio.aplication.dto.EstudiantesDTO;
import com.unicartagena.api_colegio.aplication.entities.Estudiantes;
import com.unicartagena.api_colegio.aplication.repositories.EstudiantesRepository;
import com.unicartagena.api_colegio.aplication.request.CrearEstudianteRequest;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstudianteService implements IEstudianteService {
    @Override
    public EstudiantesDTO create(CrearEstudianteRequest crearEstudianteRequest) {
        return null;

    }

    private final EstudiantesRepository estudiantesRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional(rollbackOn = Exepcion.class)
    public  EstudiantesDTO create (CrearEstudianteRequest crearEstudianteRequest){
    Optional<Estudiantes> estudiantesOptional= estudiantesRepository.findByC
    }
}
