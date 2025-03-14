package com.intercert.verifycertificate.certification.domain.model.commands;

public record CreateExecutiveCommand(
        String coachId,
        String name,
        String executiveType
) {
}
