package com.platzi.play.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/platzi/play")
public class HelloController {
    private final PlatziPlayAiService platziPlayAiService;

    public HelloController(PlatziPlayAiService platziPlayAiService) {
        this.platziPlayAiService = platziPlayAiService;
    }

    @GetMapping("/saludar")
    public String saludar(){
        return platziPlayAiService.generateGreeting();
    }
}
