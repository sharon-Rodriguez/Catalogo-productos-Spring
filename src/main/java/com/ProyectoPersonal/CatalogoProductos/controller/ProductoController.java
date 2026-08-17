package com.ProyectoPersonal.CatalogoProductos.controller;

import com.ProyectoPersonal.CatalogoProductos.model.DTOproducto;
import com.ProyectoPersonal.CatalogoProductos.model.Producto;
import com.ProyectoPersonal.CatalogoProductos.service.ApiDatos_Services;
import com.ProyectoPersonal.CatalogoProductos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ApiDatos_Services apiDatosServices;

    @GetMapping ("/{id}/convertir")
    public Map<String,Object> convertirMoneda (@PathVariable Long id, @RequestParam (defaultValue = "USD") String monedas){
        Producto producto = productoService.verProductosId(id);
        Double precio1 = producto.getPrecio();
        String precio = producto.getPrecioFormateado();
        Double monedaConvertida2 = apiDatosServices.convertidorMonedas(precio1,monedas);
        Double monedaConvertida = Math.round(monedaConvertida2 * 100.0) / 100.0;
        return Map.of(
                "monedaConvertida", monedaConvertida,
                "monedaAcambiar", monedas,
                "precio", precio,
                "nombre", producto.getNombre()
        );
    }

    @GetMapping("/{id}")
    public DTOproducto verProductoID (@PathVariable Long id){
        Producto p = productoService.verProductosId(id);
        return new DTOproducto(p) ;
    }

    @GetMapping
    public List<DTOproducto> verProductos (){
        List<Producto> lista = productoService.verProductos();
        List<DTOproducto> dto = lista.stream().map(e -> new DTOproducto(e)).toList();
        return dto;
    }

    @PostMapping
    public DTOproducto crearProducto (@RequestBody Producto producto){
        Producto p = productoService.crearProducto(producto);
        return new DTOproducto(p);
    }

    @PutMapping("/{id}")
    public DTOproducto Actualizar(@PathVariable Long id, @RequestBody Producto producto) {
        Producto p = productoService.actualizar(id,producto);
        return new DTOproducto(p);
    }

    @PatchMapping ("/{id}")
    public DTOproducto actualizacionParcial (@PathVariable long id, @RequestBody Producto producto){
        Producto p = productoService.actualizarParcial(id,producto);
        return new DTOproducto(p);
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
