package com.ProyectoPersonal.CatalogoProductos.controller;

import com.ProyectoPersonal.CatalogoProductos.model.Usuario;
import com.ProyectoPersonal.CatalogoProductos.security.ServicesUsuario;
import com.ProyectoPersonal.CatalogoProductos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/auth")
public class UsuarioController {

    @Autowired
    private UsuarioService servicesUsuario;

    @PostMapping ("/registro")
    public Usuario registro (@RequestBody Usuario usuario){
        return servicesUsuario.registro(usuario);
    }
}
