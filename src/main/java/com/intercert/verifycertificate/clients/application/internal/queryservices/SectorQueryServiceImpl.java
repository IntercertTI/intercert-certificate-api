package com.intercert.verifycertificate.clients.application.internal.queryservices;

import com.intercert.verifycertificate.clients.domain.model.entities.CompanySector;
import com.intercert.verifycertificate.clients.domain.model.queries.GetSectorByIdQuery;
import com.intercert.verifycertificate.clients.domain.services.SectorQueryService;
import com.intercert.verifycertificate.clients.infrastructure.persistence.jpa.repositories.SectorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SectorQueryServiceImpl implements SectorQueryService {

    private final SectorRepository sectorRepository;

    public SectorQueryServiceImpl(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }

    @Override
    public Optional<CompanySector> handle(GetSectorByIdQuery query) {
        return this.sectorRepository.findById(query.sectorId());
    }
}
