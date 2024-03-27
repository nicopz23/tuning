package com.ceica.securityspring.controller;

import com.ceica.securityspring.service.ColoresService;
import com.ceica.securityspring.service.LlantasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PreciosController {
    private final ColoresService coloresService;
    private final LlantasService llantasService;

    @Autowired
    public PreciosController(ColoresService coloresService, LlantasService llantasService) {
        this.coloresService = coloresService;
        this.llantasService = llantasService;
    }

    @GetMapping("/getPrecioColor")
    public ResponseEntity<String> getPrecioColor(@RequestParam("nombreColor") String nombreColor) {
        String precioColor = coloresService.getColorPrice(nombreColor);
        if (precioColor != null) {
            return ResponseEntity.ok(precioColor);
        } else {
            return ResponseEntity.notFound().build(); // Manejar el caso en que el color no existe
        }
    }

    @GetMapping("/getPrecioLlanta")
    public ResponseEntity<String> getPrecioLlanta(@RequestParam("nombreLlanta") String nombreLlanta) {
        String precioLlanta = llantasService.getLlantaPrice(nombreLlanta);
        if (precioLlanta != null) {
            return ResponseEntity.ok(precioLlanta);
        } else {
            return ResponseEntity.notFound().build(); // Manejar el caso en que la llanta no existe
        }
    }
}
