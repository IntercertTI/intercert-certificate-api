package com.intercert.verifycertificate.clients.domain.model.commands;

public record CreateCompanyCommand(
        String name,
        String taxCode,
        String activitiesDescription,
        Long sectorId
) {
}
