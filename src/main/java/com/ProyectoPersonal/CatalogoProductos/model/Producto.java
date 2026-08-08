package com.ProyectoPersonal.CatalogoProductos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double precio;
    private Integer  cantidad;

    public Producto() {
    }

    //    setter
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

   //    getter
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public Double getPrecio() { return precio; }
    public Integer getCantidad() { return cantidad; }
}
