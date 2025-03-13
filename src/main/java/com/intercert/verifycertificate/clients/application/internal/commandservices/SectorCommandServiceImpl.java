package com.intercert.verifycertificate.clients.application.internal.commandservices;

import com.intercert.verifycertificate.clients.domain.model.commands.CreateSectorCommand;
import com.intercert.verifycertificate.clients.domain.model.entities.CompanySector;
import com.intercert.verifycertificate.clients.domain.services.SectorCommandService;
import com.intercert.verifycertificate.clients.infrastructure.persistence.jpa.repositories.SectorRepository;
import org.springframework.stereotype.Service;

@Service
public class SectorCommandServiceImpl implements SectorCommandService {

    public final SectorRepository sectorRepository;

    public SectorCommandServiceImpl(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }

    @Override
    public Long handle(CreateSectorCommand command) {
        var newSector = new CompanySector(
                command.name()
        );

        try {
            this.sectorRepository.save(newSector);
            return newSector.getId();
        } catch (Exception e) {
            throw new RuntimeException("Error saving sector");
        }
    }
}
