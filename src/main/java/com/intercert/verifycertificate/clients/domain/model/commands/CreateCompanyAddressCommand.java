package com.intercert.verifycertificate.clients.domain.model.commands;

public record CreateCompanyAddressCommand(
        Long companyId,
        String phone,
        String email,
        String country,
        String taxDomicile
) {
}
