package com.intercert.verifycertificate.certification.domain.model.commands;

import java.util.Date;

public record CreateCertificateCommand(
        Long companyId,
        Long addressId,
        Long executiveId,
        Long isoNormId,
        String status,
        String registerNumber,
        String scope,
        Date initialCertificationDate,
        Date issuedCertificationDate,
        Date validityDate,
        Date recertificationDate
) {
}
