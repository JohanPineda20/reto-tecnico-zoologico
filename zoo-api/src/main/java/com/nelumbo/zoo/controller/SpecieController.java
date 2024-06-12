package com.nelumbo.zoo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelumbo.zoo.service.ISpecieService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("v1/species")
@RequiredArgsConstructor
public class SpecieController {

    private final ISpecieService specieService;
}
