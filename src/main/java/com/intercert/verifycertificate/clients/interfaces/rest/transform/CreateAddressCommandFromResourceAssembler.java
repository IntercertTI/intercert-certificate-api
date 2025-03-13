package com.intercert.verifycertificate.clients.interfaces.rest.transform;

import com.intercert.verifycertificate.clients.domain.model.commands.CreateCompanyAddressCommand;
import com.intercert.verifycertificate.clients.interfaces.rest.resources.CreateAddressResource;

public class CreateAddressCommandFromResourceAssembler {
    public static CreateCompanyAddressCommand toCommandFromResource(CreateAddressResource resource){
        return new CreateCompanyAddressCommand(
                resource.companyTaxCode(),
                resource.phone(),
                resource.email(),
                resource.country(),
                resource.taxDomicile()
        );
    }
}
