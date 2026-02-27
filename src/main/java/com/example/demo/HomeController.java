package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, Object> home() {
        return Map.of(
            "message", "Welcome to the Spring Boot API",
            "version", "1.0.0",
            "endpoints", Map.of(
                "health", "/health",
                "items", "/api/items"
            )
        );
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "healthy");
    }

    @GetMapping("/api/items")
    public Map<String, Object> items() {
        List<Map<String, Object>> items = List.of(
            Map.of("id", 1, "name", "Item One", "description", "First example item"),
            Map.of("id", 2, "name", "Item Two", "description", "Second example item"),
            Map.of("id", 3, "name", "Item Three", "description", "Third example item")
        );
        return Map.of("items", items);
    }
}
