package com.intercert.verifycertificate.certification.infrastructure.persistence.jpa.repositories;

import com.intercert.verifycertificate.certification.domain.model.aggregates.Certificate;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {
    List<Certificate> findCertificatesByCompany_TaxCode(@NotNull String companyTaxCode);
    Optional<Certificate> findCertificateByRegisterNumber(@NotNull @Size(max = 13) String registerNumber);
}
