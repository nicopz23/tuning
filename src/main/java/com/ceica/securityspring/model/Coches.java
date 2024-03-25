package com.ceica.securityspring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "coches")
public class Coches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String modelo;
    private String marca;
    private String precioBasico;
    private String pwmotor;
    private String cilindrara;
    private String velocidadMax;


    public Integer getIdcoches() {
        return id;
    }

    public void setIdcoches(Integer idcoches) {
        this.id = idcoches;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPrecioBasico() {
        return precioBasico;
    }

    public void setPrecioBasico(String precioBasico) {
        this.precioBasico = precioBasico;
    }

    public String getPwmotor() {
        return pwmotor;
    }

    public void setPwmotor(String pwmotor) {
        this.pwmotor = pwmotor;
    }

    public String getCilindrara() {
        return cilindrara;
    }

    public void setCilindrara(String cilindrara) {
        this.cilindrara = cilindrara;
    }

    public String getVelocidadMax() {
        return velocidadMax;
    }

    public void setVelocidadMax(String velocidadMax) {
        this.velocidadMax = velocidadMax;
    }
}
