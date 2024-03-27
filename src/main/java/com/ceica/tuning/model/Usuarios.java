package com.ceica.securityspring.model;

import jakarta.persistence.*;

import java.util.Collection;


@Entity
@Table(name="usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusuarios;
    private String user;
    private String password;

    /*@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idsuarios")
    private Collection<Authority> authorities;*/

    public Usuarios() {
    }


    public Integer getId() {
        return idusuarios;
    }

    public void setId(Integer id) {
        this.idusuarios = id;
    }

    public String getUser() {
        return user;
    }

    public void setUsername(String username) {
        this.user = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {


        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + idusuarios +
                ", username='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
