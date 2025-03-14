package com.intercert.verifycertificate.clients.interfaces.acl;


import com.intercert.verifycertificate.clients.domain.model.queries.GetCompanyByTaxCodeQuery;
import com.intercert.verifycertificate.clients.domain.services.CompanyCommandService;
import com.intercert.verifycertificate.clients.domain.services.CompanyQueryService;
import org.springframework.stereotype.Service;

@Service
public class CompanyContextFacade {
    private final CompanyQueryService companyQueryService;
    private final CompanyCommandService companyCommandService;

    public CompanyContextFacade(CompanyQueryService companyQueryService, CompanyCommandService companyCommandService) {
        this.companyQueryService = companyQueryService;
        this.companyCommandService = companyCommandService;
    }

    public Boolean existsCompanyByTaxCode(String taxCode) {
        var company = this.companyQueryService.handle(new GetCompanyByTaxCodeQuery(taxCode));
        return company.isPresent();
    }


}
