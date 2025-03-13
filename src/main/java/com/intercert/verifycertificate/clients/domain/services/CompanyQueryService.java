package com.intercert.verifycertificate.clients.domain.services;

import com.intercert.verifycertificate.clients.domain.model.aggregates.Company;
import com.intercert.verifycertificate.clients.domain.model.queries.GetCompanyByIdQuery;
import com.intercert.verifycertificate.clients.domain.model.queries.GetCompanyByTaxCodeQuery;

import java.util.Optional;

public interface CompanyQueryService {
    Optional<Company> handle(GetCompanyByTaxCodeQuery query);
    Optional<Company> handle(GetCompanyByIdQuery query);
}
