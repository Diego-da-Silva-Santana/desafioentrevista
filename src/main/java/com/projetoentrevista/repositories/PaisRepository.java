package com.projetoentrevista.repositories;

import com.projetoentrevista.entities.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

    Optional<Pais> findByCodigoInternacionalIso(String codigoInternacionalIso);


}
