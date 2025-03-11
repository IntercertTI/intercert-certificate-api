package com.intercert.verifycertificate.certification.domain.model.entities;

import com.intercert.verifycertificate.certification.domain.model.valueobjects.ExecutiveType;
import com.intercert.verifycertificate.shared.domain.model.entities.AuditableModel;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Executive extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nullable
    private Long coachId;

    private String name;

    private ExecutiveType executiveType;

    public Executive(String name, ExecutiveType executiveType) {
        this.name = name;
        this.executiveType = executiveType;
    }







}
