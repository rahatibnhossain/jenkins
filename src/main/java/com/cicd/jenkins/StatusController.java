package com.cicd.jenkins;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
    @Value("${app.env:none}")
    private String env;

    @GetMapping("/status")
    public String getStatus() {
        return "Backend is UP in " + env + " mode";
    }
}