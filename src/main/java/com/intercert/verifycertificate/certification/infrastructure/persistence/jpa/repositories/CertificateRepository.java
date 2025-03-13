package com.intercert.verifycertificate.certification.infrastructure.persistence.jpa.repositories;

import com.intercert.verifycertificate.certification.domain.model.aggregates.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}
