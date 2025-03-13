package com.intercert.verifycertificate.clients.interfaces.rest.resources;

public record AddressResource(
        String taxCode,
        String companyName,
        String phone,
        String email,
        String country,
        String taxDomicile
) {
}
