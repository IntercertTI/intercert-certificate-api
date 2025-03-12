package com.intercert.verifycertificate.clients.infrastructure.persistence.jpa.repositories;

import com.intercert.verifycertificate.clients.domain.model.aggregates.CompanyAddress;
import com.intercert.verifycertificate.clients.domain.model.queries.GetAddressesByCompanyQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<CompanyAddress, Long> {
    List<CompanyAddress> findCompanyAddressesByCompany_Id(GetAddressesByCompanyQuery query);
}
