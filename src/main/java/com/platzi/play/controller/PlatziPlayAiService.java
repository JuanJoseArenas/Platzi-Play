package com.platzi.play.controller;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface PlatziPlayAiService {
    @UserMessage("""
            Generame un saludo de bienvenida a la plataforma de gestion de Peliculas de PlatziPlay.
            Usa menos de 120 caracteres y hazlo con el estilo de Platzi
            """)
    String generateGreeting();
}
