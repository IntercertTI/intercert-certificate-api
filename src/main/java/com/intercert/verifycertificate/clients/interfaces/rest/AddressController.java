package com.intercert.verifycertificate.clients.interfaces.rest;

import com.intercert.verifycertificate.clients.domain.model.queries.GetAddressByIdQuery;
import com.intercert.verifycertificate.clients.domain.model.queries.GetAddressesByCompanyTaxCodeQuery;
import com.intercert.verifycertificate.clients.domain.services.AddressCommandService;
import com.intercert.verifycertificate.clients.domain.services.AddressQueryService;
import com.intercert.verifycertificate.clients.interfaces.rest.resources.AddressResource;
import com.intercert.verifycertificate.clients.interfaces.rest.resources.CreateAddressResource;
import com.intercert.verifycertificate.clients.interfaces.rest.transform.AddressResourceFromEntityAssembler;
import com.intercert.verifycertificate.clients.interfaces.rest.transform.CreateAddressCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET })
@RestController
@RequestMapping(value = "/api/v1/company-address", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Companies Addresses", description = "Addresses Management Endpoints")
public class AddressController {
    private final AddressCommandService addressCommandService;
    private final AddressQueryService addressQueryService;

    public AddressController(AddressCommandService addressCommandService, AddressQueryService addressQueryService) {
        this.addressCommandService = addressCommandService;
        this.addressQueryService = addressQueryService;
    }


    @GetMapping("/{addressId}")
    public ResponseEntity<AddressResource> getCompanyAddressById(@PathVariable Long addressId){

        var getAddressByIdQuery = new GetAddressByIdQuery(addressId);
        var optionalAddress = this.addressQueryService.handle(getAddressByIdQuery);

        if (optionalAddress.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        var addressResource = AddressResourceFromEntityAssembler
                .toResourceFromEntity(optionalAddress.get());

        return ResponseEntity.ok(addressResource);
    }

    @GetMapping
    public ResponseEntity<List<AddressResource>> getAddressesByCompanyTaxCode(@RequestParam String taxCode){

        var getAddressesByCompanyTaxCodeQuery = new GetAddressesByCompanyTaxCodeQuery(taxCode);
        var addresses = this.addressQueryService.handle(getAddressesByCompanyTaxCodeQuery);

        if (addresses.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        var addressResources = addresses.stream()
                .map(AddressResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(addressResources);
    }

    @PostMapping
    public ResponseEntity<AddressResource> createCompanyAddress(@RequestBody CreateAddressResource resource){

        var createAddressCommand = CreateAddressCommandFromResourceAssembler
                .toCommandFromResource(resource);
        var addressId = this.addressCommandService.handle(createAddressCommand);

        if (addressId.equals(0L)){
            return ResponseEntity.badRequest().build();
        }

        var getAddressByIdQuery = new GetAddressByIdQuery(addressId);
        var optionalAddress = this.addressQueryService.handle(getAddressByIdQuery);
        var addressResource = AddressResourceFromEntityAssembler.toResourceFromEntity(optionalAddress.get());

        return ResponseEntity.ok(addressResource);
    }

}
