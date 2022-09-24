package com.example.ProyectoCooperativa.servicios;

import com.example.ProyectoCooperativa.entidades.Usuario;
import com.example.ProyectoCooperativa.repositorio.RepositorioUsuario;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ServicioUsuario {

    private RepositorioUsuario repositorioUsuario;

    public ServicioUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Usuario guardarusuario(Usuario usuario){
        return this.repositorioUsuario.save(usuario);
    }

    public Usuario buscarPorEmail(String email){
        return this.repositorioUsuario.findByEmail(email);
    }

    public Usuario obtenerUsuario(Map<String,Object> datousuario){
        String email= (String) datousuario.get("email");
        Usuario usuario=buscarPorEmail(email);
        if(usuario==null){
            String nombre=(String) datousuario.get("nickname");
            String imagen=(String) datousuario.get("picture");
            String amail= (String) datousuario.get("email");
            Usuario usu= new Usuario(email,imagen,nombre);
            return  guardarusuario(usu);
        }
        System.out.println(usuario.getEmail());
        return usuario;
    }




}
