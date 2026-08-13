package com.ProyectoPersonal.CatalogoProductos.model;

import jakarta.persistence.*;

import java.text.DecimalFormat;

@Entity
@Table(name = "productos")

public class Producto {

    private static final DecimalFormat DF = new DecimalFormat();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() { return id; }

    private String nombre;
    private Double precio ;
    private Integer  cantidad;

    public Producto() {
    }

    //    setter
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

   //    getter
    public String getPrecioFormateado (){
        if (precio == null) return "0";
        return DF.format(precio);
    }
    public String getNombre() { return nombre; }
    public Double getPrecio() { return precio; }
    public Integer getCantidad() { return cantidad; }
}
