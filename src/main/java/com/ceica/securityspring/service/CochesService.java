package com.ceica.securityspring.service;

import com.ceica.securityspring.model.Coches;
import com.ceica.securityspring.repository.CochesRepository;
import org.springframework.stereotype.Service;

@Service
public class CochesService {
    private final CochesRepository cochesRepository;

    public CochesService(CochesRepository cochesRepository) {
        this.cochesRepository = cochesRepository;
    }

    public String getPwmotor(String modelo) {
        Coches coches = cochesRepository.findCochesByModelo(modelo);
        if (coches != null) {
            return coches.getPwmotor();
        } else {
            return null; // Manejar el caso en que el color no existe
        }
    }
    public String getVelocidadMax(String modelo) {
        Coches coches = cochesRepository.findCochesByModelo(modelo);
        if (coches != null) {
            return coches.getVelocidadMax();
        } else {
            return null; // Manejar el caso en que el color no existe
        }
    }
    public Integer getCilindrara(String modelo) {
        Coches coches = cochesRepository.findCochesByModelo(modelo);
        if (coches != null) {
            return coches.getCilindrara();
        } else {
            return null; // Manejar el caso en que el color no existe
        }
    }

}
