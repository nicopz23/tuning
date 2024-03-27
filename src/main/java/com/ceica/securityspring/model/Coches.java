package com.ceica.securityspring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "coches")
public class Coches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcoches;
    private String modelo;
    private String marca;
    private String precio;
    private String pwmotor;
    private Integer cilindrada;
    private String velocidadmax;

    public Coches() {
    }

    public Integer getIdcoches() {
        return idcoches;
    }

    public void setIdcoches(Integer idcoches) {
        this.idcoches = idcoches;
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
        return precio;
    }

    public void setPrecioBasico(String precioBasico) {
        this.precio = precioBasico;
    }

    public String getPwmotor() {
        return pwmotor;
    }

    public void setPwmotor(String pwmotor) {
        this.pwmotor = pwmotor;
    }

    public Integer getCilindrara() {
        return cilindrada;
    }

    public void setCilindrara(Integer cilindrara) {
        this.cilindrada = cilindrara;
    }

    public String getVelocidadMax() {
        return velocidadmax;
    }

    public void setVelocidadMax(String velocidadMax) {
        this.velocidadmax = velocidadMax;
    }
}
