package com.intercert.verifycertificate.certification.domain.model.aggregates;

import com.intercert.verifycertificate.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class Company extends AuditableAbstractAggregateRoot<Company> {

    @NotNull
    private String companyName;

    private String companyCode;


}
