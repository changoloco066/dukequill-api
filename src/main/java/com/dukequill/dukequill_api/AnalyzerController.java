package com.dukequill.dukequill_api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AnalyzerController {

    @PostMapping("/analyze")
    public String analyze(@RequestBody String text) {
        return "Texto recibido: " + text;
    }
}