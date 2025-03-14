package com.intercert.verifycertificate.certification.interfaces.rest.resources;

public record ExecutiveResource(
        String name,
        String type,
        CoachResource coach
) {
}
