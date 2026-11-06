package com.unicartagena.api_colegio.aplication.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unicartagena.api_colegio.aplication.entities.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {

    Optional<Roles> findByNombre(String nombre);
}
