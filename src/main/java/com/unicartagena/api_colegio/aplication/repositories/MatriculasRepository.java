package com.unicartagena.api_colegio.aplication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unicartagena.api_colegio.aplication.entities.Matriculas;

@Repository
public interface MatriculasRepository extends JpaRepository<Matriculas, Long> {

    List<Matriculas> findByPeriodoAcademico(String periodoAcademico);
}
