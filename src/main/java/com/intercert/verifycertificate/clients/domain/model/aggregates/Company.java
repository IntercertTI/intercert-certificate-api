package com.intercert.verifycertificate.clients.domain.model.aggregates;

import com.intercert.verifycertificate.clients.domain.model.entities.CompanySector;
import com.intercert.verifycertificate.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Company extends AuditableAbstractAggregateRoot<Company> {

    @NotNull
    private String name;

    @NotNull
    private String taxCode;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String activitiesDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sector_id")
    @NotNull
    @Setter
    private CompanySector sector;


    public Company(String name, String taxCode, String activitiesDescription) {
        this.name = name;
        this.taxCode = taxCode;
        this.activitiesDescription = activitiesDescription;
    }




}
