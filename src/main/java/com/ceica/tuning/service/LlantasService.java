package com.ceica.securityspring.service;

import com.ceica.securityspring.model.Llantas;
import com.ceica.securityspring.repository.LlantasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LlantasService {
    private final LlantasRepository llantasRepository;

    @Autowired
    public LlantasService(LlantasRepository llantasRepository) {
        this.llantasRepository = llantasRepository;
    }

    public String getLlantaPrice(String nombreLlanta) {
        Llantas llanta = llantasRepository.findByNombre(nombreLlanta);
        if (llanta != null) {
            return llanta.getPrecio();
        } else {
            return null; // Manejar el caso en que la llanta no existe
        }
    }
}
