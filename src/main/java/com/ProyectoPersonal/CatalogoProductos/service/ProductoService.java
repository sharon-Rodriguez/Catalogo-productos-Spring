package com.ProyectoPersonal.CatalogoProductos.service;

import com.ProyectoPersonal.CatalogoProductos.model.Producto;
import com.ProyectoPersonal.CatalogoProductos.model.Usuario;
import com.ProyectoPersonal.CatalogoProductos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Producto verProductosId(Long id){
        return productoRepository.findById(id).orElseThrow();
    }

    public List<Producto> verProductos (){
        return productoRepository.findAll();
    }

    public Producto crearProducto (Producto producto){
        return productoRepository.save(producto);
    }

    public Producto actualizarParcial (Long id, Producto productoActualizado) {
        Producto producto1 = productoRepository.findById(id).orElseThrow();

        if (productoActualizado.getNombre() != null){
            producto1.setNombre(productoActualizado.getNombre());
        }
        if (productoActualizado.getCantidad() != null){
            producto1.setCantidad(productoActualizado.getCantidad());
        }
        if (productoActualizado.getPrecio() != null){
            producto1.setPrecio(productoActualizado.getPrecio());
        }
        return productoRepository.save(producto1);
    }

    public Producto actualizar (Long id, Producto productoActualizado){
        Producto producto1 = productoRepository.findById(id).orElseThrow();
        producto1.setNombre(productoActualizado.getNombre());
        producto1.setCantidad(productoActualizado.getCantidad());
        producto1.setCantidad(productoActualizado.getCantidad());
        return productoRepository.save(producto1);
    }

    public void EliminarTodos () { productoRepository.deleteAll();}

    public void Eliminar (Long id){
        productoRepository.deleteById(id);
    }
}
