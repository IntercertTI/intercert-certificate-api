package com.intercert.verifycertificate.certification.domain.model.commands;

import java.util.Date;

public record UpdateCertificateCommand(
        Long addressId,
        Long executiveId,
        String status,
        String scope,
        Date issuedCertificationDate,
        Date validityDate,
        Date recertificationDate
) {
}
