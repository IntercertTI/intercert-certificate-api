package com.intercert.verifycertificate.clients.interfaces.rest.transform;

import com.intercert.verifycertificate.clients.domain.model.aggregates.Company;
import com.intercert.verifycertificate.clients.interfaces.rest.resources.CompanyResource;

public class CompanyResourceFromEntityAssembler {
    public static CompanyResource toResourceFromEntity(Company entity) {
        return new CompanyResource(
                entity.getName(),
                entity.getTaxCode(),
                entity.getActivitiesDescription(),
                entity.getSector().getName()
        );
    }
}