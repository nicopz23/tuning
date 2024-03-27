package com.ceica.securityspring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "llantas")
public class Llantas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idllantas;
    private String tipo;
    private String precio;

    public Llantas() {
    }

    public Integer getId() {
        return idllantas;
    }

    public void setId(Integer id) {
        this.idllantas = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
