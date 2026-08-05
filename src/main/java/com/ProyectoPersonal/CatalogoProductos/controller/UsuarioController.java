package com.ProyectoPersonal.CatalogoProductos.controller;

import com.ProyectoPersonal.CatalogoProductos.model.MuestraUsuario;
import com.ProyectoPersonal.CatalogoProductos.model.Usuario;
import com.ProyectoPersonal.CatalogoProductos.security.ServicesUsuario;
import com.ProyectoPersonal.CatalogoProductos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/auth")
public class UsuarioController {

    @Autowired
    private UsuarioService servicesUsuario;

    @GetMapping ("/mostrar")
    public List<MuestraUsuario> usuarios (){
        return servicesUsuario.mostrarUsuariosTodos();
    }

    @GetMapping ("/mostrar/{id}")
    public MuestraUsuario mostrarUsuario (@PathVariable Long id){
        return servicesUsuario.mostrarUsuario(id);
    }

    @PostMapping ("/registro")
    public Usuario registro (@RequestBody Usuario usuario){
        return servicesUsuario.registro(usuario);
    }
}
