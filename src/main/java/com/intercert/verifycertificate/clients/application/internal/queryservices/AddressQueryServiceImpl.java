package com.intercert.verifycertificate.clients.application.internal.queryservices;

import com.intercert.verifycertificate.clients.domain.model.aggregates.CompanyAddress;
import com.intercert.verifycertificate.clients.domain.model.queries.GetAddressByIdQuery;
import com.intercert.verifycertificate.clients.domain.model.queries.GetAddressesByCompanyIdQuery;
import com.intercert.verifycertificate.clients.domain.model.queries.GetAddressesByCompanyTaxCodeQuery;
import com.intercert.verifycertificate.clients.domain.services.AddressQueryService;
import com.intercert.verifycertificate.clients.infrastructure.persistence.jpa.repositories.AddressRepository;
import com.intercert.verifycertificate.clients.infrastructure.persistence.jpa.repositories.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressQueryServiceImpl implements AddressQueryService {

    private final AddressRepository addressRepository;
    private final CompanyRepository companyRepository;

    public AddressQueryServiceImpl(AddressRepository addressRepository, CompanyRepository companyRepository) {
        this.addressRepository = addressRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<CompanyAddress> handle(GetAddressesByCompanyIdQuery query) {
        return this.addressRepository.findCompanyAddressesByCompany_Id(query.companyId());
    }

    @Override
    public Optional<CompanyAddress> handle(GetAddressByIdQuery query) {
        return this.addressRepository.findById(query.addressId());
    }

    @Override
    public List<CompanyAddress> handle(GetAddressesByCompanyTaxCodeQuery query) {
        if (this.companyRepository.existsByTaxCode(query.taxCode())) {
            new RuntimeException("Company not found");
        }

        return this.addressRepository.findCompanyAddressByCompany_TaxCode(query.taxCode());
    }
}
