package com.unicartagena.api_colegio.aplication.repositories;

import com.unicartagena.api_colegio.aplication.entities.Profesores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfesoresRepository extends JpaRepository<Profesores, Long> {

    Optional<Profesores> findByNombre(String nombre);
    Optional<Profesores> findByCorreo(String correo);
    Optional<Profesores> findByIdentificacion(Long identificacion);
}
