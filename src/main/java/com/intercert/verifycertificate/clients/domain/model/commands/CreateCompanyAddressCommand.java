package com.intercert.verifycertificate.clients.domain.model.commands;

public record CreateCompanyAddressCommand(
        String companyTaxCode,
        String phone,
        String email,
        String country,
        String taxDomicile
) {
}
