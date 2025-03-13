package com.intercert.verifycertificate.certification.application.internal.queryservices;

import com.intercert.verifycertificate.certification.application.internal.outboundservices.ExternalCompanyService;
import com.intercert.verifycertificate.certification.domain.model.aggregates.Certificate;
import com.intercert.verifycertificate.certification.domain.model.queries.GetCertificateByRegitstrationNumberQuery;
import com.intercert.verifycertificate.certification.domain.model.queries.GetCertificatesByCompanyTaxCodeQuery;
import com.intercert.verifycertificate.certification.domain.services.CertificateQueryService;
import com.intercert.verifycertificate.certification.infrastructure.persistence.jpa.repositories.CertificateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificateQueryServiceImpl implements CertificateQueryService {

    private final CertificateRepository certificateRepository;
    private final ExternalCompanyService externalCompanyService;

    public CertificateQueryServiceImpl(CertificateRepository certificateRepository, ExternalCompanyService externalCompanyService) {
        this.certificateRepository = certificateRepository;
        this.externalCompanyService = externalCompanyService;
    }

    @Override
    public Optional<Certificate> handle(GetCertificateByRegitstrationNumberQuery query) {
        return this.certificateRepository.findCertificateByRegisterNumber(query.registrationNumber());
    }

    @Override
    public List<Certificate> handle(GetCertificatesByCompanyTaxCodeQuery query) {
        if (!externalCompanyService.existsCompanyByTaxCode(query.taxCode())) {
            throw new RuntimeException("Company not found");
        }
        return this.certificateRepository.findCertificatesByCompany_TaxCode(query.taxCode());
    }
}
