package com.ceica.securityspring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "colores")
public class Colores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String precio;
}
