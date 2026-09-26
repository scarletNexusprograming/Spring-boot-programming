package com.unicartagena.api_colegio.aplication.repositories;

import com.unicartagena.api_colegio.aplication.entities.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    List<Matricula> findByEstudianteId(Long estudianteId);

    List<Matricula> findByGradoId(Long gradoId);

    Optional<Matricula> findByEstudianteIdAndGradoIdAndPeriodoAcademico(
            Long estudianteId, Long gradoId, String periodoAcademico);
}