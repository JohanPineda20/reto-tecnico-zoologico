package com.nelumbo.zoo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelumbo.zoo.service.IMetricService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("v1/metrics")
@RequiredArgsConstructor
public class MetricController {

    private final IMetricService metricService;
}
