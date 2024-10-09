package com.getPlace.demo.services;

import com.getPlace.demo.model.LocationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

@Service
public class GeolocationService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiKey = "ed1be12434814538a01a0896d0fb6471"; // Chave da OpenCage
    public LocationResponse getLocation(Double lat, Double lon) {
        String url = String.format("https://api.opencagedata.com/geocode/v1/json?q=%f,%f&key=%s", lat, lon, apiKey);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("API externa não está disponível.");
        }
        String body = response.getBody();
        // Parse JSON e extrair as informações necessárias
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(body);
            JsonNode results = root.path("results").get(0);
            String formattedAddress = results.path("formatted").asText();
            String city = results.path("components").path("city").asText();
            String state = results.path("components").path("state").asText();
            String country = results.path("components").path("country").asText();

            return new LocationResponse(formattedAddress, lat, lon, city, state, country);

        } catch (IOException e) {
            throw new RuntimeException("Erro ao processar a resposta da API: " + e.getMessage());
        }
    }
}
