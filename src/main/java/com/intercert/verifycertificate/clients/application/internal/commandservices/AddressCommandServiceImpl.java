package com.intercert.verifycertificate.clients.application.internal.commandservices;

import com.intercert.verifycertificate.clients.domain.model.aggregates.Company;
import com.intercert.verifycertificate.clients.domain.model.aggregates.CompanyAddress;
import com.intercert.verifycertificate.clients.domain.model.commands.CreateCompanyAddressCommand;
import com.intercert.verifycertificate.clients.domain.services.AddressCommandService;
import com.intercert.verifycertificate.clients.infrastructure.persistence.jpa.repositories.AddressRepository;
import com.intercert.verifycertificate.clients.infrastructure.persistence.jpa.repositories.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressCommandServiceImpl implements AddressCommandService {

    private final AddressRepository addressRepository;
    private final CompanyRepository companyRepository;

    public AddressCommandServiceImpl(AddressRepository addressRepository, CompanyRepository companyRepository) {
        this.addressRepository = addressRepository;
        this.companyRepository = companyRepository;
    }


    @Override
    public Long handle(CreateCompanyAddressCommand command) {

        var company = this.companyRepository.findByTaxCode(command.companyTaxCode());

        if (company.isEmpty()) {
            throw new RuntimeException("Company not found");
        }

        var newAddress = new CompanyAddress(
            company.get(),
            command.phone(),
            command.email(),
            command.country(),
            command.taxDomicile()
        );

        try {
            this.addressRepository.save(newAddress);
            return newAddress.getId();
        } catch (Exception e) {
            throw new RuntimeException("Error saving address: " + e.getMessage());
        }
    }
}
