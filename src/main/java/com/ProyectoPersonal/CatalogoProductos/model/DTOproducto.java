package com.ProyectoPersonal.CatalogoProductos.model;

public class DTOproducto {

    private Long id;
    private String nombre;
    private String precio ;
    private Integer cantidad;

    public DTOproducto(Producto p) {
        this.id = p.getId();
        this.nombre = p.getNombre();
        this.precio = p.getPrecioFormateado();
        this.cantidad = p.getCantidad();
    }


    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }
}
