package com.intercert.verifycertificate.certification.interfaces.rest.transform;

import com.intercert.verifycertificate.certification.domain.model.entities.Executive;
import com.intercert.verifycertificate.certification.interfaces.rest.resources.CoachResource;

public class CoachResourceFromEntityAssembler {
    public static CoachResource toResourceFromEntity(Executive resource) {
        return new CoachResource(
                resource.getName(),
                resource.getExecutiveType().toString()
        );
    }
}
