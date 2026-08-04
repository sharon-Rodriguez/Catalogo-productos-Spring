package com.ProyectoPersonal.CatalogoProductos.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table (name = "usuarios")

public class Usuario implements UserDetails {

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
    public long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getContraseña() { return contraseña; }
    public Rol getRol() { return rol; }

//    setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEmail(String email) { this.email = email; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
    public void setRol(Rol rol) { this.rol = rol; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(rol.name()));
    }

    @Override
    public String getPassword() {
        return contraseña;
    }

    @Override
    public String getUsername() {
        return email;
    }

}
