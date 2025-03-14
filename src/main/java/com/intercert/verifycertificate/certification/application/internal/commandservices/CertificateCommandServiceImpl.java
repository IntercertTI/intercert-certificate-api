package com.intercert.verifycertificate.certification.application.internal.commandservices;

import com.intercert.verifycertificate.certification.application.internal.outboundservices.ExternalAddressService;
import com.intercert.verifycertificate.certification.application.internal.outboundservices.ExternalCompanyService;
import com.intercert.verifycertificate.certification.domain.model.aggregates.Certificate;
import com.intercert.verifycertificate.certification.domain.model.commands.CreateCertificateCommand;
import com.intercert.verifycertificate.certification.domain.model.commands.UpdateCertificateCommand;
import com.intercert.verifycertificate.certification.domain.services.CertificateCommandService;
import com.intercert.verifycertificate.certification.infrastructure.persistence.jpa.repositories.CertificateRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CertificateCommandServiceImpl implements CertificateCommandService {

    private final CertificateRepository certificateRepository;
    private final ExternalCompanyService externalCompanyService;
    private final ExternalAddressService externalAddressService;

    public CertificateCommandServiceImpl(CertificateRepository certificateRepository, ExternalCompanyService externalCompanyService, ExternalAddressService externalAddressService) {
        this.certificateRepository = certificateRepository;
        this.externalCompanyService = externalCompanyService;
        this.externalAddressService = externalAddressService;
    }


    @Override
    public Long handle(CreateCertificateCommand command) {
        return 0L;
    }

    @Override
    public Optional<Certificate> handle(UpdateCertificateCommand command) {
        return Optional.empty();
    }
}
