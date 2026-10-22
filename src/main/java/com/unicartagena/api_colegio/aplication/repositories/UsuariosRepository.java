
package com.unicartagena.api_colegio.aplication.repositories;

import com.unicartagena.api_colegio.aplication.entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

    // Peticiones personalizadas para buscar usuarios
    Optional<Usuarios> findByNombre(String nombre);

    Optional<Usuarios> findByApellido(String apellido);

    Optional<Usuarios> findByCorreo(String correo);

    Optional<Usuarios> findByEstado(Boolean estado);
}
