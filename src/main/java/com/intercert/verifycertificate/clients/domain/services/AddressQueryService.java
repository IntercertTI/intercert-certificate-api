package com.intercert.verifycertificate.clients.domain.services;

import com.intercert.verifycertificate.clients.domain.model.aggregates.CompanyAddress;
import com.intercert.verifycertificate.clients.domain.model.queries.GetAddressByIdQuery;
import com.intercert.verifycertificate.clients.domain.model.queries.GetAddressesByCompanyQuery;

import java.util.List;
import java.util.Optional;

public interface AddressQueryService {
    List<CompanyAddress> handle(GetAddressesByCompanyQuery query);
    Optional<CompanyAddress> handle(GetAddressByIdQuery query);
}
