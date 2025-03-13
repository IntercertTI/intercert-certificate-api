package com.intercert.verifycertificate.certification.interfaces.rest;

import com.intercert.verifycertificate.certification.domain.model.queries.GetCertificateByRegitstrationNumberQuery;
import com.intercert.verifycertificate.certification.domain.services.CertificateQueryService;
import com.intercert.verifycertificate.certification.interfaces.rest.resources.CertificateResource;
import com.intercert.verifycertificate.certification.interfaces.rest.transform.CertificateResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT })
@RestController
@RequestMapping(value = "/api/v1/certificate", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Certificates", description = "Certificates Management Endpoints")
public class CertificateController {

    private final CertificateQueryService certificateQueryService;

    public CertificateController(CertificateQueryService certificateQueryService) {
        this.certificateQueryService = certificateQueryService;
    }

    @GetMapping("/registration-number")
    public ResponseEntity<CertificateResource> getCertificateByRegistrationNumber(@RequestParam String registrationNumber) {

        var getCertificateByRegistrationNumberQuery = new GetCertificateByRegitstrationNumberQuery(registrationNumber);

        var certificate = this.certificateQueryService.handle(getCertificateByRegistrationNumberQuery);

        if (certificate.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var certificateResource = CertificateResourceFromEntityAssembler
                .toResourceFromEntity(certificate.get());

        return ResponseEntity.ok(certificateResource);
    }


}
