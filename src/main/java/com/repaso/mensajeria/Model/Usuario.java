package com.repaso.mensajeria.Model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long id;

    private String nombre;

    private String email;

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public Usuario() {

    }

    @Override
    public String toString() {
        return String.format("Usuario [%d]: %s - %s",id , nombre, email);
    }
}
