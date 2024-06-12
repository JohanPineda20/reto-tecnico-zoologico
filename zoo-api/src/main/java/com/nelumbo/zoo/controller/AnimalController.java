package com.nelumbo.zoo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelumbo.zoo.service.IAnimalService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("v1/animals")
@RequiredArgsConstructor
public class AnimalController {

    private final IAnimalService animalService;
}
