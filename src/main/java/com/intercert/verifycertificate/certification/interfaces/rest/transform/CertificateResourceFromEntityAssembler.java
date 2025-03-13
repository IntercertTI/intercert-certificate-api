package com.intercert.verifycertificate.certification.interfaces.rest.transform;

import com.intercert.verifycertificate.certification.domain.model.aggregates.Certificate;
import com.intercert.verifycertificate.certification.interfaces.rest.resources.CertificateResource;

public class CertificateResourceFromEntityAssembler {
    public static CertificateResource toResourceFromEntity(Certificate entity){
        return new CertificateResource(
                entity.getCompany().getName(),
                entity.getAddress().getTaxDomicile(),
                entity.getIsoNorm().getIsoCode(),
                entity.getIsoNorm().getName(),
                entity.getStatus().toString(),
                entity.getRegisterNumber(),
                entity.getScope(),
                entity.getInitialCertificationDate(),
                entity.getIssuedCertificationDate(),
                entity.getValidityDate(),
                entity.getRecertificationDate()
        );
    }
}
