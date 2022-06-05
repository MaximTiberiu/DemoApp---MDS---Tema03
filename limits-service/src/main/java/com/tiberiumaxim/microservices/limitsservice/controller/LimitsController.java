package com.tiberiumaxim.microservices.limitsservice.controller;

import com.tiberiumaxim.microservices.limitsservice.config.Configuration;
import com.tiberiumaxim.microservices.limitsservice.model.Limits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    private final Configuration configuration;

    public LimitsController(Configuration configuration) {
        this.configuration = configuration;
    }

    @GetMapping("/limits")
    public Limits retrieveLimits() {
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }
}
