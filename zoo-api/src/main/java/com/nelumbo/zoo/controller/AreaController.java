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

import com.nelumbo.zoo.dto.request.CreateAreaRequest;
import com.nelumbo.zoo.dto.response.AreaResponse;
import com.nelumbo.zoo.mappers.dto.AreaDtoMapper;
import com.nelumbo.zoo.model.CustomPage;
import com.nelumbo.zoo.service.IAreaService;
import com.nelumbo.zoo.utils.Constants;
import com.nelumbo.zoo.utils.CustomPageConverter;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("v1/areas")
@RequiredArgsConstructor
public class AreaController {

    private final IAreaService areaService;
    private final AreaDtoMapper areaDtoMapper;

    @PreAuthorize(Constants.ADMIN_OR_EMPLOYEE_ALLOWED)
    @GetMapping
    public ResponseEntity<CustomPage<AreaResponse>> findAll(@RequestParam(defaultValue = "0") Integer page,
                                                                  @RequestParam(defaultValue = "10") Integer size) {
        CustomPage<AreaResponse> createAreaResponsePage = CustomPageConverter.convertCustomPage(areaService.findAll(page, size), areaDtoMapper::toAreaResponse); 
        return ResponseEntity.ok(createAreaResponsePage);
    }

    @PreAuthorize(Constants.ADMIN_OR_EMPLOYEE_ALLOWED)
    @GetMapping("{id}")
    public ResponseEntity<AreaResponse> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(areaDtoMapper.toAreaResponse(areaService.findOneWithSpecies(id)));
    }

    @PreAuthorize(Constants.ADMIN_ALLOWED)
    @PostMapping
    public ResponseEntity<AreaResponse> create(@RequestBody @Valid CreateAreaRequest CreateAreaRequest) {
        AreaResponse areaResponse = areaDtoMapper.toAreaResponse(areaService.create(areaDtoMapper.toAreaModel(CreateAreaRequest)));
        return ResponseEntity.created(URI.create(String.format("/api/v1/areas/%s", areaResponse.getId())))
        .body(areaResponse);
    }

    @PreAuthorize(Constants.ADMIN_ALLOWED)
    @PutMapping("{id}")
    public ResponseEntity<AreaResponse> update(@PathVariable Long id, @RequestBody @Valid CreateAreaRequest createAreaRequest) {
        AreaResponse areaResponse = areaDtoMapper.toAreaResponse(areaService.update(id, areaDtoMapper.toAreaModel(createAreaRequest)));
        return ResponseEntity.ok(areaResponse);
    }

    @PreAuthorize(Constants.ADMIN_ALLOWED)
    @DeleteMapping("{id}")
    public ResponseEntity<AreaResponse> delete(@PathVariable Long id) {
        AreaResponse areaResponse = areaDtoMapper.toAreaResponse(areaService.delete(id));
        return ResponseEntity.ok(areaResponse);
    }
}
