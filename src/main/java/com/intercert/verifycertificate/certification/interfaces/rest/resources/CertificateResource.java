package com.intercert.verifycertificate.certification.interfaces.rest.resources;

import java.util.Date;

public record CertificateResource(
        String companyName,
        String companyAddress,
        String isoCode,
        String isoName,
        String status,
        String registerNumber,
        String scope,
        Date initialCertificationDate,
        Date issuedCertificationDate,
        Date validityDate,
        Date recertificationDate
) {
}
