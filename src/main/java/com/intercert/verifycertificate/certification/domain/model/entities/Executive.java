package com.intercert.verifycertificate.certification.domain.model.entities;

import com.intercert.verifycertificate.certification.domain.model.valueobjects.ExecutiveType;
import com.intercert.verifycertificate.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
public class Executive extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coach_id")
    private Executive coach;

    @NotNull
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ExecutiveType executiveType;

    public Executive(String name, ExecutiveType executiveType) {
        this.name = name;
        this.executiveType = executiveType;
    }


}
