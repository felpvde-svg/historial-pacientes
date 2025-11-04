package com.felipe.historialpacientes.Domain.Repository;

import com.felipe.historialpacientes.Domain.model.Entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {
    Optional<PacienteEntity> findByDocumento(String documento);
}
