package com.intercert.verifycertificate.clients.domain.services;

import com.intercert.verifycertificate.clients.domain.model.commands.CreateCompanyCommand;

public interface CompanyCommandService {
    Long handle(CreateCompanyCommand command);
}
