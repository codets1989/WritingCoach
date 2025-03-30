package com.example.WritingCoach.service;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PythonLLMService {
    private final WebClient webClient;

    public PythonLLMService() {
        this.webClient = WebClient.create("http://localhost:8000"); // Python FastAPI URL
    }

    public Mono<String> correctGrammar(String text) {
        return webClient.post()
                .uri("/correct")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(Map.of("text", text))
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> checkGrammar(String text) {
        return webClient.post()
                .uri("/check_grammar")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(Map.of("text", text))
                .retrieve()
                .bodyToMono(String.class);
    }
}