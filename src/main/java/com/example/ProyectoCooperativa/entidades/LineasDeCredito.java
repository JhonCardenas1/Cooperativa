package com.example.ProyectoCooperativa.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Lineas_de_credito")
public class LineasDeCredito {
    @Id
    private int codigo;
    @Column(nullable = false, length = 30,unique = true)
    private String nombre;
    @Column(name = "monto_maximo")
    private int montoMax;
    @Column(name = "plazo_maximo")
    private int plazoMax;

    public LineasDeCredito(int codigo, String nombre, int montoMax, int plazoMax) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.montoMax = montoMax;
        this.plazoMax = plazoMax;
    }

    public LineasDeCredito() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMontoMax() {
        return montoMax;
    }

    public void setMontoMax(int montoMax) {
        this.montoMax = montoMax;
    }

    public int getPlazoMax() {
        return plazoMax;
    }

    public void setPlazoMax(int plazoMax) {
        this.plazoMax = plazoMax;
    }

}
