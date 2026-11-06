package com.unicartagena.api_colegio.aplication.repositories;

import com.unicartagena.api_colegio.aplication.entities.Materias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MateriasRepository extends JpaRepository<Materias, Long> {

    Optional<Materias> findByCodigo(String codigo);
    Optional<Materias> findByNombre(String nombre);
}
