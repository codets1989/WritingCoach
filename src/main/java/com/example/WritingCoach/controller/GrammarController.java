package com.example.WritingCoach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.WritingCoach.service.PythonLLMService;
import reactor.core.publisher.Mono;
import com.example.WritingCoach.model.TextRequest; 
@RestController
@RequestMapping("/api/grammar")
public class GrammarController {

    @Autowired
    private PythonLLMService pythonLLMService;

    // Endpoint to correct grammar
    @PostMapping("/correct")
    public Mono<String> correctGrammar(@RequestBody TextRequest request) {
        return pythonLLMService.correctGrammar(request.getText());
    }

    // Endpoint to check grammar
    @PostMapping("/check")
    public Mono<String> checkGrammar(@RequestBody TextRequest request) {
        return pythonLLMService.checkGrammar(request.getText());
    }
}