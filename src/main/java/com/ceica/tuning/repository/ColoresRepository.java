package com.ceica.securityspring.repository;
import com.ceica.securityspring.model.Colores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColoresRepository extends JpaRepository<Colores, Integer> {
    Colores findByNombre(String nombre);
}
