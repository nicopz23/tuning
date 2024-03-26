package com.ceica.securityspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CochesController {
    @GetMapping("/coches")
    public String user(){
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
                return "boxter";
            } else if ("Cayman".equals(titulo)) {
                return "cayman";
            } else if ("Cayman Style".equals(titulo)) {
                return "caymanstyle";
            } else if ("Boxster Style".equals(titulo)) {
                return "boxterStyle";
            } else {
                // Manejar casos no previstos
                return "coches";
            }
        }
    }

