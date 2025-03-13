package com.intercert.verifycertificate.clients.interfaces.rest.transform;

import com.intercert.verifycertificate.clients.domain.model.aggregates.CompanyAddress;
import com.intercert.verifycertificate.clients.interfaces.rest.resources.AddressResource;

public class AddressResourceFromEntityAssembler {
    public static AddressResource toResourceFromEntity(CompanyAddress entity) {
        return new AddressResource(
            entity.getCompany().getTaxCode(),
            entity.getCompany().getName(),
            entity.getPhone(),
            entity.getEmail(),
            entity.getCountry(),
            entity.getTaxDomicile()
        );
    }
}
