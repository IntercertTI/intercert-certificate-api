package com.intercert.verifycertificate.clients.infrastructure.persistence.jpa.repositories;

import com.intercert.verifycertificate.clients.domain.model.entities.CompanySector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepository extends JpaRepository<CompanySector, Long> {
}
