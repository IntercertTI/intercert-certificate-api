package com.intercert.verifycertificate.clients.interfaces.rest.resources;

public record CreateAddressResource(
        String companyTaxCode,
        String phone,
        String email,
        String country,
        String taxDomicile
) {
}
