package com.intercert.verifycertificate.certification.domain.model.entities;

import com.intercert.verifycertificate.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.Entity;
import jakarta.persistence.*;


@Entity
public class IsoNorm extends AuditableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isoCode;

    private String name;

    private String description;

    public IsoNorm() {
    }

    public IsoNorm(String isoCode, String name, String description) {
        this.isoCode = isoCode;
        this.name = name;
        this.description = description;
    }


}
