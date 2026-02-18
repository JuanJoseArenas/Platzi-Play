package com.platzi.play.web.controller;

import com.platzi.play.domain.service.PlatziPlayAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class HelloController {
    private final String plataform;
    private final PlatziPlayAiService platziPlayAiService;

    public HelloController(@Value("${spring.application.name}")String plataform, PlatziPlayAiService platziPlayAiService) {
        this.plataform = plataform;
        this.platziPlayAiService = platziPlayAiService;
    }

    @GetMapping("/saludar")
    public String saludar(){
        return platziPlayAiService.generateGreeting(plataform);
    }
}
