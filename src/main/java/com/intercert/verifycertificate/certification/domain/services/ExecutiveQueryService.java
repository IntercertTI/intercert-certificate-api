package com.intercert.verifycertificate.certification.domain.services;

import com.intercert.verifycertificate.certification.domain.model.entities.Executive;
import com.intercert.verifycertificate.certification.domain.model.queries.GetExecutiveByIdQuery;

import java.util.Optional;

public interface ExecutiveQueryService {
    Optional<Executive> handle(GetExecutiveByIdQuery query);
}
