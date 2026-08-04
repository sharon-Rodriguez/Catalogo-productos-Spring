package com.ProyectoPersonal.CatalogoProductos.service;

import com.ProyectoPersonal.CatalogoProductos.model.MuestraUsuario;
import com.ProyectoPersonal.CatalogoProductos.model.Usuario;
import com.ProyectoPersonal.CatalogoProductos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<MuestraUsuario> mostrarUsuariosTodos (){
        return usuarioRepository.findAll()
                .stream()
                .map(e -> new MuestraUsuario(e.getNombre(), e.getEmail(), e.getId(), e.getRol()))
                .toList();
    }

    public MuestraUsuario mostrarUsuario (Long id){
        return usuarioRepository.findById(id)
                .map(e -> new MuestraUsuario(e.getNombre(), e.getEmail(), e.getId(), e.getRol()))
                .orElseThrow(()->new RuntimeException("Usuario con id= " + id + " no encontrado o no existe"));
    }

    public Usuario registro (Usuario usuario){
        usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));
        return usuarioRepository.save(usuario);
    }
}
