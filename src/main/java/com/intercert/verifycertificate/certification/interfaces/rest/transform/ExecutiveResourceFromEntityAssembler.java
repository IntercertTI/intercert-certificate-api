package com.intercert.verifycertificate.certification.interfaces.rest.transform;

import com.intercert.verifycertificate.certification.domain.model.entities.Executive;
import com.intercert.verifycertificate.certification.interfaces.rest.resources.CoachResource;
import com.intercert.verifycertificate.certification.interfaces.rest.resources.ExecutiveResource;

public class ExecutiveResourceFromEntityAssembler {
    public static ExecutiveResource toResourceFromEntity(Executive resource) {

        if (resource.getCoach() == null) {
            return new ExecutiveResource(
                    resource.getName(),
                    resource.getExecutiveType().toString(),
                    new CoachResource("No coach", "No coach")
            );
        }


        return new ExecutiveResource(
                resource.getName(),
                resource.getExecutiveType().toString(),
                CoachResourceFromEntityAssembler.toResourceFromEntity(resource.getCoach())
        );
    }
}
