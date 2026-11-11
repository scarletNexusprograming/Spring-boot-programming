package com.unicartagena.api_colegio.aplication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unicartagena.api_colegio.aplication.entities.MaterialAcademico;

@Repository
public interface MaterialAcademicoRepository extends JpaRepository<MaterialAcademico, Long> {

    List<MaterialAcademico> findByTipo(String tipo);
}
