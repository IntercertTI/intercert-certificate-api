package com.intercert.verifycertificate.clients.interfaces.rest.transform;

import com.intercert.verifycertificate.clients.domain.model.commands.CreateCompanyCommand;
import com.intercert.verifycertificate.clients.interfaces.rest.resources.CreateCompanyResource;

public class CreateCompanyCommandFromResourceAssembler {
    public static CreateCompanyCommand toCommandFromResource(CreateCompanyResource resource){
        return new CreateCompanyCommand(
                resource.name(),
                resource.taxCode(),
                resource.activitiesDescription(),
                resource.sectorId()
        );
    }
}
