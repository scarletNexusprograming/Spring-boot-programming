package com.unicartagena.api_colegio.aplication.repositories;

import com.unicartagena.api_colegio.aplication.entities.Notas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
@Repository
public interface NotasRepository extends JpaRepository<Notas, Long>{

    List<Notas>findByEstudianteId(Long estudianteId);
    List<Notas>findByMateriaId(Long materiaId);
    List<Notas> findByEstudianteIdAndMateriaId(
            Long estudianteId,
            Long materiaId
    );

    Collection<Object> findByPeriodo(Integer periodo);
}