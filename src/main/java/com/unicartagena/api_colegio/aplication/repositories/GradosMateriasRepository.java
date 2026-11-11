package com.unicartagena.api_colegio.aplication.repositories;

import com.unicartagena.api_colegio.aplication.entities.GradosMaterias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradosMateriasRepository extends JpaRepository<GradosMaterias, Long> {

    // Sin consultas personalizadas por ahora: cuando se agreguen las relaciones
    // se podrán buscar materias por grado y grados por materia.
}
