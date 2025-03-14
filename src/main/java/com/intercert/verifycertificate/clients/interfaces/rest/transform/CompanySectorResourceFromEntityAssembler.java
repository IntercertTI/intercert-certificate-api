package com.intercert.verifycertificate.clients.interfaces.rest.transform;

import com.intercert.verifycertificate.clients.domain.model.entities.CompanySector;
import com.intercert.verifycertificate.clients.interfaces.rest.resources.CompanySectorResource;

public class CompanySectorResourceFromEntityAssembler {
    public static CompanySectorResource toResourceFromEntity(CompanySector entity) {
        return new CompanySectorResource(
                entity.getId(),
                entity.getName()
        );
    }
}
