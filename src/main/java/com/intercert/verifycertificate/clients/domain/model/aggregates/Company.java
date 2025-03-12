package com.intercert.verifycertificate.clients.domain.model.aggregates;

import com.intercert.verifycertificate.clients.domain.model.entities.CompanySector;
import com.intercert.verifycertificate.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Company extends AuditableAbstractAggregateRoot<Company> {

    @NotNull
    private String companyName;

    @NotNull
    private String companyCode;

    @NotNull
    private String activitiesDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sector_id")
    @NotNull
    private CompanySector sector;


    public Company(String companyName, String companyCode, String activitiesDescription) {
        this.companyName = companyName;
        this.companyCode = companyCode;
        this.activitiesDescription = activitiesDescription;
    }




}
