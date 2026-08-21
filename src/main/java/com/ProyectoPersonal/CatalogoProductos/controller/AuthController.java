package com.ProyectoPersonal.CatalogoProductos.controller;

import com.ProyectoPersonal.CatalogoProductos.model.DTOusuario;
import com.ProyectoPersonal.CatalogoProductos.model.Usuario;
import com.ProyectoPersonal.CatalogoProductos.security.TokenServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenServices tokenServices;

    @PostMapping("/login")
    public String login (@RequestBody DTOusuario usuario){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        usuario.email(),
                        usuario.contraseña()
                )
        );
        Usuario usuarioAutorizado = (Usuario) authentication.getPrincipal();
        return tokenServices.generarToken(usuarioAutorizado.getEmail());
    }

}
