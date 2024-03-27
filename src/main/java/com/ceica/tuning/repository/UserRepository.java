package com.ceica.securityspring.repository;


import com.ceica.securityspring.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuarios, Integer> {
    Usuarios findByUser(String user);
}
