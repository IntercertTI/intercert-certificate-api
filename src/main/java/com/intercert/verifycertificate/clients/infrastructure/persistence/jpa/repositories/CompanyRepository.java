package com.intercert.verifycertificate.clients.infrastructure.persistence.jpa.repositories;

import com.intercert.verifycertificate.clients.domain.model.aggregates.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByTaxCode(String taxCode);
}