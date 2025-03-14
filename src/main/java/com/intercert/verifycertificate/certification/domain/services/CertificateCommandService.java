package com.intercert.verifycertificate.certification.domain.services;

import com.intercert.verifycertificate.certification.domain.model.aggregates.Certificate;
import com.intercert.verifycertificate.certification.domain.model.commands.CreateCertificateCommand;
import com.intercert.verifycertificate.certification.domain.model.commands.UpdateCertificateCommand;

import java.util.Optional;

public interface CertificateCommandService {
    Long handle(CreateCertificateCommand command);
    Optional<Certificate> handle(UpdateCertificateCommand command);
}
