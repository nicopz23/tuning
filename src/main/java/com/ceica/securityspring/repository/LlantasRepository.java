package com.ceica.securityspring.repository;

import com.ceica.securityspring.model.Llantas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LlantasRepository extends JpaRepository<Llantas, Integer> {
    Llantas findByTipo(String tipo);
}

