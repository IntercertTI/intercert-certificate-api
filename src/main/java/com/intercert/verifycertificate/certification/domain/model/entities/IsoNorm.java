package com.intercert.verifycertificate.certification.domain.model.entities;

import com.intercert.verifycertificate.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Getter
public class IsoNorm extends AuditableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String isoCode;

    @NotNull
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public IsoNorm(String isoCode, String name, String description) {
        this.isoCode = isoCode;
        this.name = name;
        this.description = description;
    }


}
