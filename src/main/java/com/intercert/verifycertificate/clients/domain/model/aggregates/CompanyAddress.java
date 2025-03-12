package com.intercert.verifycertificate.clients.domain.model.aggregates;

import com.intercert.verifycertificate.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class CompanyAddress extends AuditableAbstractAggregateRoot<CompanyAddress> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    @NotNull
    private Company company;

    private String phone;

    @Email
    private String email;

    @NotNull
    private String country;

    @NotNull
    private String taxDomicle;

    public CompanyAddress(Company company,String phone, String email, String taxDomicle) {
        this.company = company;
        this.phone = phone;
        this.email = email;
        this.taxDomicle = taxDomicle;
    }

}
