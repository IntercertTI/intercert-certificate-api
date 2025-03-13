package com.intercert.verifycertificate.clients.interfaces.rest;


import com.intercert.verifycertificate.clients.domain.model.queries.GetSectorByIdQuery;
import com.intercert.verifycertificate.clients.domain.services.SectorCommandService;
import com.intercert.verifycertificate.clients.domain.services.SectorQueryService;
import com.intercert.verifycertificate.clients.interfaces.rest.resources.CompanySectorResource;
import com.intercert.verifycertificate.clients.interfaces.rest.resources.CreateSectorResource;
import com.intercert.verifycertificate.clients.interfaces.rest.transform.CompanySectorResourceFromEntityAssembler;
import com.intercert.verifycertificate.clients.interfaces.rest.transform.CreateSectorCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET })
@RestController
@RequestMapping(value = "/api/v1/company-sector", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Company Sectors", description = "Sectors Management Endpoints")
public class SectorController {

    private final SectorQueryService sectorQueryService;
    private final SectorCommandService sectorCommandService;

    public SectorController(SectorQueryService sectorQueryService, SectorCommandService sectorCommandService) {
        this.sectorQueryService = sectorQueryService;
        this.sectorCommandService = sectorCommandService;
    }

    @GetMapping("/{sectorId}")
    public ResponseEntity<CompanySectorResource> getSectorById(@PathVariable Long sectorId) {
        var getSectorById = new GetSectorByIdQuery(sectorId);
        var optionalSector = this.sectorQueryService.handle(getSectorById);

        if (optionalSector.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var sectorResource = CompanySectorResourceFromEntityAssembler.toResourceFromEntity(optionalSector.get());

        return ResponseEntity.ok(sectorResource);

    }

    @PostMapping
    public ResponseEntity<CompanySectorResource> createSector(@RequestBody CreateSectorResource resource){
        var createSectorCommand = CreateSectorCommandFromResourceAssembler.toCommandFromResource(resource);
        var sectorId = this.sectorCommandService.handle(createSectorCommand);

        if (sectorId.equals(0L)){
            return ResponseEntity.badRequest().build();
        }

        var getSectorByIdQuery = new GetSectorByIdQuery(sectorId);
        var optionalSector = this.sectorQueryService.handle(getSectorByIdQuery);
        var sectorResource = CompanySectorResourceFromEntityAssembler.toResourceFromEntity(optionalSector.get());
        return new ResponseEntity<>(sectorResource, HttpStatus.CREATED);
    }

}
