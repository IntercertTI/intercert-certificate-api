package com.intercert.verifycertificate.certification.application.internal.outboundservices;

import com.intercert.verifycertificate.clients.interfaces.acl.CompanyContextFacade;
import org.springframework.stereotype.Service;

@Service
public class ExternalCompanyService {

    private final CompanyContextFacade companyContextFacade;

    public ExternalCompanyService(CompanyContextFacade companyContextFacade) {
        this.companyContextFacade = companyContextFacade;
    }

    public Boolean existsCompanyByTaxCode(String taxCode) {
        return companyContextFacade.existsCompanyByTaxCode(taxCode);
    }

}
