package com.nelumbo.zoo.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nelumbo.zoo.dto.request.CreateSpecieRequest;
import com.nelumbo.zoo.dto.response.SpecieResponse;
import com.nelumbo.zoo.mappers.dto.SpecieDtoMapper;
import com.nelumbo.zoo.model.CustomPage;
import com.nelumbo.zoo.service.ISpecieService;
import com.nelumbo.zoo.utils.Constants;
import com.nelumbo.zoo.utils.CustomPageConverter;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("v1/species")
@RequiredArgsConstructor
public class SpecieController {

    private final ISpecieService specieService;
    private final SpecieDtoMapper specieDtoMapper;

    @PreAuthorize(Constants.ADMIN_OR_EMPLOYEE_ALLOWED)
    @GetMapping
    public ResponseEntity<CustomPage<SpecieResponse>> findAll(@RequestParam(defaultValue = "0") Integer page,
                                                              @RequestParam(defaultValue = "10") Integer size) {
        CustomPage<SpecieResponse> specieResponsePage = CustomPageConverter.convertCustomPage(specieService.findAll(page, size), specieDtoMapper::toSpecieResponse); 
        return ResponseEntity.ok(specieResponsePage);
    }

    @PreAuthorize(Constants.ADMIN_OR_EMPLOYEE_ALLOWED)
    @GetMapping("{id}")
    public ResponseEntity<SpecieResponse> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(specieDtoMapper.toSpecieResponse(specieService.findOneWithArea(id)));
    }

    @PreAuthorize(Constants.ADMIN_ALLOWED)
    @PostMapping
    public ResponseEntity<SpecieResponse> create(@RequestBody @Valid CreateSpecieRequest createSpecieRequest) {
        SpecieResponse specieResponse = specieDtoMapper.toSpecieResponse(specieService.create(specieDtoMapper.toSpecieModel(createSpecieRequest)));
        return ResponseEntity.created(URI.create(String.format("/api/v1/species/%s", specieResponse.getId())))
        .body(specieResponse);
    }

    @PreAuthorize(Constants.ADMIN_ALLOWED)
    @PutMapping("{id}")
    public ResponseEntity<SpecieResponse> update(@PathVariable Long id, @RequestBody @Valid CreateSpecieRequest createSpecieRequest) {
        SpecieResponse specieResponse = specieDtoMapper.toSpecieResponse(specieService.update(id, specieDtoMapper.toSpecieModel(createSpecieRequest)));
        return ResponseEntity.ok(specieResponse);
    }

    @PreAuthorize(Constants.ADMIN_ALLOWED)
    @DeleteMapping("{id}")
    public ResponseEntity<SpecieResponse> delete(@PathVariable Long id) {
        SpecieResponse specieResponse = specieDtoMapper.toSpecieResponse(specieService.delete(id));
        return ResponseEntity.ok(specieResponse);
    }
}