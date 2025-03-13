package com.intercert.verifycertificate.clients.domain.services;

import com.intercert.verifycertificate.clients.domain.model.entities.CompanySector;
import com.intercert.verifycertificate.clients.domain.model.queries.GetSectorByIdQuery;

import java.util.Optional;

public interface SectorQueryService {
    Optional<CompanySector> handle(GetSectorByIdQuery query);
}
