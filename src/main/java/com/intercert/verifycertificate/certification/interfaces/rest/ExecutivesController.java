package com.intercert.verifycertificate.certification.interfaces.rest;


import com.intercert.verifycertificate.certification.domain.model.queries.GetExecutiveByIdQuery;
import com.intercert.verifycertificate.certification.domain.services.ExecutiveQueryService;
import com.intercert.verifycertificate.certification.interfaces.rest.resources.ExecutiveResource;
import com.intercert.verifycertificate.certification.interfaces.rest.transform.ExecutiveResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT })
@RestController
@RequestMapping(value = "/api/v1/executive", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Executives", description = "Executives Management Endpoints")
public class ExecutivesController {

    private final ExecutiveQueryService executiveQueryService;

    public ExecutivesController(ExecutiveQueryService executiveQueryService) {
        this.executiveQueryService = executiveQueryService;
    }

    @GetMapping("/{executiveId}")
    public ResponseEntity<ExecutiveResource> getExecutiveById(@PathVariable Long executiveId){

        var getExecutiveByIdQuery = new GetExecutiveByIdQuery(executiveId);
        var optionalExecutive = this.executiveQueryService.handle(getExecutiveByIdQuery);

        if (optionalExecutive.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        var executiveResource = ExecutiveResourceFromEntityAssembler.toResourceFromEntity(optionalExecutive.get());
        return ResponseEntity.ok(executiveResource);



    }

}
