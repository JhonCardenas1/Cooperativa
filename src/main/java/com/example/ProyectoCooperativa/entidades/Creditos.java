package com.example.ProyectoCooperativa.entidades;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Creditos {

    @Id
    private int codido;
    @Column(name="monto_prestado",nullable = false)
    private int montoPrestado;
    @Column(name="plazo_prestado",nullable = false)
    private int plazoPrestado;
    @Column(name="fecha_desembolso", nullable= false)
    private Date fechaDesembolso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="documentocliente",nullable = false)
    private Cliente cli;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="codigo_linea", nullable = false)
    private LineasDeCredito lc;

    public Creditos(int codido, int montoPrestado, int plazoPrestafo, Date fechaDesembolso, Cliente cli, LineasDeCredito lc) {
        this.codido = codido;
        this.montoPrestado = montoPrestado;
        this.plazoPrestado = plazoPrestafo;
        this.fechaDesembolso = fechaDesembolso;
        this.cli = cli;
        this.lc = lc;
    }

    public Creditos() {
    }

    public int getCodido() {
        return codido;
    }

    public void setCodido(int codido) {
        this.codido = codido;
    }

    public int getMontoPrestado() {
        return montoPrestado;
    }

    public void setMontoPrestado(int montoPrestado) {
        this.montoPrestado = montoPrestado;
    }

    public int getPlazoPrestafo() {
        return plazoPrestado;
    }

    public void setPlazoPrestafo(int plazoPrestafo) {
        this.plazoPrestado = plazoPrestafo;
    }

    public Date getFechaDesembolso() {
        return fechaDesembolso;
    }

    public void setFechaDesembolso(Date fechaDesembolso) {
        this.fechaDesembolso = fechaDesembolso;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public LineasDeCredito getLc() {
        return lc;
    }

    public void setLc(LineasDeCredito lc) {
        this.lc = lc;
    }
}
