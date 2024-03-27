package com.ceica.securityspring.repository;

import com.ceica.securityspring.model.Configuracion;
import com.ceica.securityspring.model.Llantas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;

public interface ConfiguracionRepository extends JpaRepository<Configuracion, Integer> {
    Configuracion findByColorAndLlantas(Color color, Llantas llantas);
}