package com.intercert.verifycertificate.clients.application.internal.commandservices;

import com.intercert.verifycertificate.clients.domain.model.aggregates.Company;
import com.intercert.verifycertificate.clients.domain.model.commands.CreateCompanyCommand;
import com.intercert.verifycertificate.clients.domain.services.CompanyCommandService;
import com.intercert.verifycertificate.clients.infrastructure.persistence.jpa.repositories.CompanyRepository;
import com.intercert.verifycertificate.clients.infrastructure.persistence.jpa.repositories.SectorRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyCommandServiceImpl implements CompanyCommandService {

    private final CompanyRepository companyRepository;
    private final SectorRepository sectorRepository;

    public CompanyCommandServiceImpl(CompanyRepository companyRepository, SectorRepository sectorRepository) {
        this.companyRepository = companyRepository;
        this.sectorRepository = sectorRepository;
    }

    @Override
    public Long handle(CreateCompanyCommand command) {

        var sector = this.sectorRepository.findById(command.sectorId())
                .orElseThrow(() -> new RuntimeException("Sector not found"));

        var newCompany = new Company(
                command.name(),
                command.taxCode(),
                command.activitiesDescription()
        );
        newCompany.setSector(sector);

        try {
            this.companyRepository.save(newCompany);
            return newCompany.getId();
        } catch (Exception e) {
            throw new RuntimeException("Error saving company: " + e.getMessage());
        }
    }
}
