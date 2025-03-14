package com.intercert.verifycertificate.certification.domain.services;

import com.intercert.verifycertificate.certification.domain.model.aggregates.Certificate;
import com.intercert.verifycertificate.certification.domain.model.queries.GetCertificateByRegitstrationNumberQuery;
import com.intercert.verifycertificate.certification.domain.model.queries.GetCertificatesByCompanyTaxCodeQuery;

import java.util.List;
import java.util.Optional;

public interface CertificateQueryService {
    Optional<Certificate> handle(GetCertificateByRegitstrationNumberQuery query);
    List<Certificate> handle(GetCertificatesByCompanyTaxCodeQuery query);
}
