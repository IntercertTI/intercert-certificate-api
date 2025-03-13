package com.intercert.verifycertificate.clients.interfaces.rest.transform;

import com.intercert.verifycertificate.clients.domain.model.commands.CreateSectorCommand;
import com.intercert.verifycertificate.clients.interfaces.rest.resources.CreateSectorResource;

public class CreateSectorCommandFromResourceAssembler {
    public static CreateSectorCommand toCommandFromResource(CreateSectorResource resource) {
        return new CreateSectorCommand(
                resource.name()
        );
    }
}
