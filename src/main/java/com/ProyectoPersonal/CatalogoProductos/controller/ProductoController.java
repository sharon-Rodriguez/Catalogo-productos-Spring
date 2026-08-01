package com.ProyectoPersonal.CatalogoProductos.controller;

import com.ProyectoPersonal.CatalogoProductos.model.Producto;
import com.ProyectoPersonal.CatalogoProductos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/{id}")
    public Producto verProductoID (@PathVariable Long id){
        return productoService.verProductosId(id);
    }

    @GetMapping
    public List<Producto> verProductos (){
        return productoService.verProductos();
    }

    @PostMapping
    public Producto crearProducto (@RequestBody Producto producto){
        return productoService.crearProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto ActualizarProducto(
            @PathVariable Long id,
            @RequestBody Producto producto
    ) {
        return productoService.actualizar(id,producto);
        }

    @DeleteMapping
        public void EliminarTodos(){
        productoService.EliminarTodos();
    }

    @DeleteMapping("/{id}")
    public void EliminarProducto (@PathVariable Long id){
        productoService.Eliminar(id);
    }
}
