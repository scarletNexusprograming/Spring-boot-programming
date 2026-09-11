package com.unicartagena.api_colegio.repository;

import com.unicartagena.api_colegio.model.EstudianteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<EstudianteModel, Long> {
}
