package com.intercert.verifycertificate.certification.application.internal.queryservices;

import com.intercert.verifycertificate.certification.domain.model.entities.Executive;
import com.intercert.verifycertificate.certification.domain.model.queries.GetExecutiveByIdQuery;
import com.intercert.verifycertificate.certification.domain.services.ExecutiveQueryService;
import com.intercert.verifycertificate.certification.infrastructure.persistence.jpa.repositories.ExecutiveRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExecutiveQueryServiceImpl implements ExecutiveQueryService {

    private final ExecutiveRepository executiveRepository;

    public ExecutiveQueryServiceImpl(ExecutiveRepository executiveRepository) {
        this.executiveRepository = executiveRepository;
    }


    @Override
    public Optional<Executive> handle(GetExecutiveByIdQuery query) {
        return this.executiveRepository.findById(query.executiveId());
    }
}
