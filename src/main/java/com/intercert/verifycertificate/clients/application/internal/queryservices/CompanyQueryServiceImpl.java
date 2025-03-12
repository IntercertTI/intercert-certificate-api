package com.intercert.verifycertificate.clients.application.internal.queryservices;

import com.intercert.verifycertificate.clients.domain.model.aggregates.Company;
import com.intercert.verifycertificate.clients.domain.model.queries.GetCompanyByTaxCodeQuery;
import com.intercert.verifycertificate.clients.domain.services.CompanyQueryService;
import com.intercert.verifycertificate.clients.infrastructure.persistence.jpa.repositories.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyQueryServiceImpl implements CompanyQueryService {

    private final CompanyRepository companyRepository;

    public CompanyQueryServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Optional<Company> handle(GetCompanyByTaxCodeQuery query) {
        return this.companyRepository.findByTaxCode(query.taxCode());
    }


}
