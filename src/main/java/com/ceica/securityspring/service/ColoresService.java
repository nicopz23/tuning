package com.ceica.securityspring.service;

import com.ceica.securityspring.model.Colores;
import com.ceica.securityspring.repository.ColoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColoresService {
    private final ColoresRepository coloresRepository;

    @Autowired
    public ColoresService(ColoresRepository coloresRepository) {
        this.coloresRepository = coloresRepository;
    }

    public String getColorPrice(String nombreColor) {
        Colores color = coloresRepository.findByNombre(nombreColor);
        if (color != null) {
            return color.getPrecio();
        } else {
            return null; // Manejar el caso en que el color no existe
        }
    }
}

