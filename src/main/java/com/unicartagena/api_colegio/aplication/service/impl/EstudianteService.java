package com.unicartagena.api_colegio.aplication.service.impl;

import com.unicartagena.api_colegio.aplication.dto.EstudiantesDTO;
import com.unicartagena.api_colegio.aplication.request.CrearEstudianteRequest;
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
}
