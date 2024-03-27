package com.ceica.securityspring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "colores")
public class Colores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcolores;
    private String nombre;
    private String precio;

    public Colores() {
    }

    public Integer getId() {
        return idcolores;
    }

    public void setId(Integer id) {
        this.idcolores = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
