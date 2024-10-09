package com.getPlace.demo.controllers;

import com.getPlace.demo.model.Coordinates;
import com.getPlace.demo.model.LocationResponse;
import com.getPlace.demo.services.GeolocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class GeolocationController {
    @Autowired
    private GeolocationService geolocationService;

    @GetMapping("/location")
    public ResponseEntity<Object> getLocationByCoordinates(@RequestParam Double lat, @RequestParam Double lon) {
        LocationResponse response = geolocationService.getLocation(lat, lon);
        Map<String, String> locationInfo = new HashMap<>();
        locationInfo.put("Cidade", response.getCity());
        locationInfo.put("Estado", response.getState());
        locationInfo.put("País", response.getCountry());
        return ResponseEntity.ok(locationInfo);
    }

    @PostMapping("/coordinates")
    public ResponseEntity<Object> getLocationFromBody(@RequestBody Coordinates coordinates) {
        LocationResponse response = geolocationService.getLocation(coordinates.getLat(), coordinates.getLon());
        Map<String, String> locationInfo = new HashMap<>();
        locationInfo.put("Cidade", response.getCity());
        locationInfo.put("Estado", response.getState());
        locationInfo.put("País", response.getCountry());
        return ResponseEntity.ok(locationInfo);
    }

    @GetMapping("/sobre")
    public ResponseEntity<Map<String, String>> sobre() {
        Map<String, String> sobreInfo = new HashMap<>();
        sobreInfo.put("Nome", "Arturo Burigo");
        sobreInfo.put("Nome do projeto", "Onde eu tô?");
        return ResponseEntity.ok(sobreInfo);
    }
}
