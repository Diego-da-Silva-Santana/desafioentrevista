package com.projetoentrevista.repositories;

import com.projetoentrevista.entities.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaisRepository extends JpaRepository<Pais, String> {

    Optional<Pais> findByCodigoInternacionalIso(String codigoInternacionalIso);
}
