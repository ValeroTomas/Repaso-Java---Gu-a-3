package com.repaso.mensajeria.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long id;

    private String nombre;

    @Email
    @Column(unique = true)
    private String email;

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public Usuario() {

    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("Usuario [%d]: %s - %s",id , nombre, email);
    }
}
