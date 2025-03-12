package com.intercert.verifycertificate.certification.domain.model.aggregates;

import com.intercert.verifycertificate.certification.domain.model.entities.Executive;
import com.intercert.verifycertificate.certification.domain.model.entities.IsoNorm;
import com.intercert.verifycertificate.certification.domain.model.valueobjects.CertificateStatus;
import com.intercert.verifycertificate.clients.domain.model.aggregates.Company;
import com.intercert.verifycertificate.clients.domain.model.aggregates.CompanyAddress;
import com.intercert.verifycertificate.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
public class Certificate extends AuditableAbstractAggregateRoot<Certificate> {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    @NotNull
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    @NotNull
    private CompanyAddress address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "executive_id")
    @NotNull
    private Executive executive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iso_norm_id")
    @NotNull
    private IsoNorm isoNorm;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CertificateStatus status;

    @NotNull
    private String registerNumber;

    @NotNull
    private String scope;

    @NotNull
    private Date initialCertificationDate;

    @NotNull
    private Date issuedCertificationDate;

    @NotNull
    private Date validityDate;

    @NotNull
    private Date recertificationDate;


    public Certificate(Company company,
                       CompanyAddress address,
                       Executive executive,
                       IsoNorm isoNorm,
                       CertificateStatus status,
                       String registerNumber,
                       String scope,
                       Date initialCertificationDate,
                       Date issuedCertificationDate,
                       Date validityDate,
                       Date recertificationDate) {
        this.company = company;
        this.address = address;
        this.executive = executive;
        this.isoNorm = isoNorm;
        this.status = status;
        this.registerNumber = registerNumber;
        this.scope = scope;
        this.initialCertificationDate = initialCertificationDate;
        this.issuedCertificationDate = issuedCertificationDate;
        this.validityDate = validityDate;
        this.recertificationDate = recertificationDate;
    }




}
