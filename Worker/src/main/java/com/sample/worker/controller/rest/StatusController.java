package com.sample.worker.controller.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/status")
public class StatusController {

    @GetMapping("/isAvailable")
    public Boolean isAvailable() {
        return true;
    }
}
