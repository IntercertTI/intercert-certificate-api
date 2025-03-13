package com.intercert.verifycertificate.clients.domain.services;

import com.intercert.verifycertificate.clients.domain.model.commands.CreateCompanyAddressCommand;

public interface AddressCommandService {
    Long handle(CreateCompanyAddressCommand command);
}
