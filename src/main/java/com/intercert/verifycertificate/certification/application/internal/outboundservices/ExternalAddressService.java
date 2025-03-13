package com.intercert.verifycertificate.certification.application.internal.outboundservices;

import com.intercert.verifycertificate.clients.interfaces.acl.AddressContextFacade;
import org.springframework.stereotype.Service;

@Service
public class ExternalAddressService {

    private final AddressContextFacade addressContextFacade;

    public ExternalAddressService(AddressContextFacade addressContextFacade) {
        this.addressContextFacade = addressContextFacade;
    }



}
