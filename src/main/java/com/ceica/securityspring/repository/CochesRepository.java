package com.ceica.securityspring.repository;

import com.ceica.securityspring.model.Coches;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CochesRepository extends JpaRepository<Coches, Integer> {
    Coches findCochesByModelo(String modelo);
}
