package com.nelumbo.zoo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelumbo.zoo.service.IAreaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("v1/areas")
@RequiredArgsConstructor
public class AreaController {

    private final IAreaService areaService;
}
