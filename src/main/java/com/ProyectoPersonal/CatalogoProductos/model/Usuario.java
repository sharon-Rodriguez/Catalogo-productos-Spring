package com.ProyectoPersonal.CatalogoProductos.model;

import jakarta.persistence.*;

@Entity
@Table (name = "usuarios")

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    private String nombre ;
    private String email ;
    private String contraseña ;

    @Enumerated(EnumType.STRING)
    private Rol rol ;

    public Usuario() {
    }

//    getters
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getContraseña() { return contraseña; }
    public Rol getRol() { return rol; }

//    setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEmail(String email) { this.email = email; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
    public void setRol(Rol rol) { this.rol = rol; }

}
