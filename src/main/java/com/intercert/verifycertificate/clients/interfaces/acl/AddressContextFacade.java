package com.intercert.verifycertificate.clients.interfaces.acl;

import com.intercert.verifycertificate.clients.domain.services.AddressCommandService;
import com.intercert.verifycertificate.clients.domain.services.AddressQueryService;
import org.springframework.stereotype.Service;

@Service
public class AddressContextFacade {

    private final AddressQueryService addressQueryService;
    private final AddressCommandService addressCommandService;

    public AddressContextFacade(AddressQueryService addressQueryService, AddressCommandService addressCommandService) {
        this.addressQueryService = addressQueryService;
        this.addressCommandService = addressCommandService;
    }



}
