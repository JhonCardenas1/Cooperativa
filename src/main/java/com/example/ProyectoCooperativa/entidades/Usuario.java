package com.example.ProyectoCooperativa.entidades;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class Usuario {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "email")
    private String email;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = " nombreUsuario")
    private String nombreUsuario;

    public Usuario(String email, String imagen, String nombreUsuario) {

        this.email = email;
        this.imagen = imagen;
        this.nombreUsuario = nombreUsuario;
    }

    public Usuario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
