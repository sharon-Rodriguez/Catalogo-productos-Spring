package com.ProyectoPersonal.CatalogoProductos.security;

import com.ProyectoPersonal.CatalogoProductos.model.Usuario;
import com.ProyectoPersonal.CatalogoProductos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ServicesUsuario implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername (String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("No se encontró usuairo"));

        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getContraseña())
                .authorities(new SimpleGrantedAuthority(usuario.getRol().name()))
                .build();
    }
}
