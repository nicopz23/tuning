package com.ceica.securityspring.controller;

import com.ceica.securityspring.model.Coches;
import com.ceica.securityspring.service.CochesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CochesController {
    private final CochesService cochesService;

    @Autowired
    public CochesController(CochesService cochesService) {
        this.cochesService = cochesService;
    }
    @GetMapping("/informacionAdicional")
    @ResponseBody
    public Map<String, String> obtenerInformacionAdicional(@RequestParam("modelo") String modelo) {
        Map<String, String> infoAdicional = new HashMap<>();
        infoAdicional.put("pwmotor", cochesService.getPwmotor(modelo));
        infoAdicional.put("velocidadMax", cochesService.getVelocidadMax(modelo));
        infoAdicional.put("cilindrara", String.valueOf(cochesService.getCilindrara(modelo)));
        return infoAdicional;
    }
    @GetMapping("/coches")
    public String user() {
        return "coches";
    }

    @PostMapping("/cochescontroller")
    @ResponseBody
    public String manejarClicEnDiv(@RequestBody String titulo) {
        // Aquí determina la URL a la que se debe redirigir según el título recibido
        String pagina = determinarPagina(titulo);
        // Retorna la URL de la página a la que se debe redirigir
        return pagina;
    }

    private String determinarPagina(String titulo) {
        // Lógica para determinar la URL a partir del título recibido
        // Por ejemplo:
        if ("Boxster".equals(titulo)) {
            return "boxster";
        } else if ("Cayman".equals(titulo)) {
            return "cayman";
        } else if ("Cayman Style".equals(titulo)) {
            return "caymanStyle";
        } else if ("Boxster Style".equals(titulo)) {
            return "boxsterStyle";
        } else {
            // Manejar casos no previstos
            return "coches";
        }
    }

    @GetMapping("/boxster")
    public String boxster() {
        return "boxster";
    }

    @GetMapping("/cayman")
    public String cayman() {
        return "cayman";
    }

    @GetMapping("/caymanStyle")
    public String caymanstyle() {
        return "caymanStyle";
    }

    @GetMapping("/boxsterStyle")
    public String boxsterstyle() {
        return "boxsterStyle";
    }

}



