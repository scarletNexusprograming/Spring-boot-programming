package com.unicartagena.api_colegio.aplication.repositories;

import com.unicartagena.api_colegio.aplication.entities.Estudiantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstudiantesRepository extends JpaRepository<Estudiantes, Long> {

    //no se agrega el id porque biene por defecto
    Optional<Estudiantes> findByNombre(String nombre);
    Optional<Estudiantes> findByCorreo(String correo);
    Optional<Estudiantes> findByIdentificacion(Long identificacion);
}