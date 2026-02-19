package com.platzi.play.domain.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface PlatziPlayAiService {
    @UserMessage("""
            Generame un saludo de bienvenida a la plataforma de gestion de Peliculas de {{plataform}}.
            Usa menos de 120 caracteres y hazlo con el estilo de Platzi
            """)
    String generateGreeting(@V("plataform") String plataform);

    @SystemMessage("""
            Eres un asistente de recomendacion de peliculas, tu tarea es recomendar peliculas a los usuarios de la plataforma de gestion de Peliculas de Platzi.
            Para eso, debes analizar el mensaje del usuario y recomendarle una pelicula que se ajuste a sus gustos.
            Usa menos de 120 caracteres y hazlo con el estilo de Platzi, solo recomienda 3 peliculas.
            No incluyas peliculas que esten por fuera de la plataforma PlatziPlay
            """)
    String generateMovieSuggestion(@UserMessage String userMessage);
}
