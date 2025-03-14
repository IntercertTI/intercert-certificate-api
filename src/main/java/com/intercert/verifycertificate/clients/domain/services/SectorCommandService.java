package com.intercert.verifycertificate.clients.domain.services;

import com.intercert.verifycertificate.clients.domain.model.commands.CreateSectorCommand;


public interface SectorCommandService {
    Long handle(CreateSectorCommand command);
}
