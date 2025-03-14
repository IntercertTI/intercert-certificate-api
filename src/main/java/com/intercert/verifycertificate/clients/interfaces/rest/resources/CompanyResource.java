package com.intercert.verifycertificate.clients.interfaces.rest.resources;

public record CompanyResource(
        String name,
        String taxCode,
        String activitiesDescription,
        String sector
) {
}
