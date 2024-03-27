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

    @GetMapping("/getPrecio")
    public ResponseEntity<String> getPrecio(@RequestParam("nombreColor") String nombreColor, @RequestParam("nombreLlanta") String nombreLlanta) {
        String precioColor = coloresService.getColorPrice(nombreColor);
        String precioLlanta = llantasService.getLlantaPrice(nombreLlanta);

        if (precioColor != null && precioLlanta != null) {
            return ResponseEntity.ok("Precio del color: " + precioColor + ", Precio de la llanta: " + precioLlanta);
        } else {
            return ResponseEntity.notFound().build(); // Manejar el caso en que el color o la llanta no existen
        }
    }
}

