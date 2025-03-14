package com.intercert.verifycertificate.clients.interfaces.rest.resources;

public record CreateCompanyResource(
        String name,
        String taxCode,
        String activitiesDescription,
        Long sectorId
) {
}
