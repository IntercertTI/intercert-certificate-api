package com.intercert.verifycertificate.certification.infrastructure.persistence.jpa.repositories;

import com.intercert.verifycertificate.certification.domain.model.entities.Executive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExecutiveRepository extends JpaRepository<Executive, Long> {
}
