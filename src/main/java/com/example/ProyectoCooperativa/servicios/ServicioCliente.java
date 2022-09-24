package com.example.ProyectoCooperativa.servicios;

import com.example.ProyectoCooperativa.entidades.Cliente;

import java.util.List;
import java.util.Map;

public interface ServicioCliente {

    public List<Cliente>listarClientes();
    public Cliente guardarClientes(Cliente cliente);
    public Cliente consultarClientesPorId(Integer documento);
    public Cliente actualizarClientes(Cliente cliente);
    public void eliminarClientesId(Integer documento);

    public Cliente actualizarPorId(Integer doc, Map<Object,Object> objectMap);


}
