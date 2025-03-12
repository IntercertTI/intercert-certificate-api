package com.intercert.verifycertificate.clients.interfaces.rest;

import com.intercert.verifycertificate.clients.domain.model.queries.GetCompanyByTaxCodeQuery;
import com.intercert.verifycertificate.clients.domain.services.CompanyCommandService;
import com.intercert.verifycertificate.clients.domain.services.CompanyQueryService;
import com.intercert.verifycertificate.clients.interfaces.rest.resources.CompanyResource;
import com.intercert.verifycertificate.clients.interfaces.rest.transform.CompanyResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET })
@RestController
@RequestMapping(value = "/api/v1/companies", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Companies", description = "Companies Management Endpoints")
public class CompanyController {

    private final CompanyQueryService companyQueryService;
    private final CompanyCommandService companyCommandService;

    public CompanyController(CompanyQueryService companyQueryService, CompanyCommandService companyCommandService) {
        this.companyQueryService = companyQueryService;
        this.companyCommandService = companyCommandService;
    }

    @GetMapping("/{taxCode}")
    public ResponseEntity<CompanyResource> getCompanyByTaxCode(@PathVariable String taxCode){

        var getCompanyByTaxCode = new GetCompanyByTaxCodeQuery(taxCode);
        var optionalCompany = this.companyQueryService.handle(getCompanyByTaxCode);

        if (optionalCompany.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        var companyResource = CompanyResourceFromEntityAssembler.toResourceFromEntity(optionalCompany.get());

        return ResponseEntity.ok(companyResource);
    }


}
