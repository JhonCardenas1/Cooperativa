package com.example.ProyectoCooperativa.controlador;

import com.example.ProyectoCooperativa.entidades.Cliente;
import com.example.ProyectoCooperativa.entidades.Usuario;
import com.example.ProyectoCooperativa.servicios.ServicioImpCliente;
import com.example.ProyectoCooperativa.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//@RequestMapping("/cliente")
//@RestController
@Controller

public class ControladorCliente {

    @Autowired
    private ServicioImpCliente sic;
    @Autowired
    private ServicioUsuario serviciousuario;

    public ControladorCliente(ServicioUsuario serviciousuario) {
        this.serviciousuario = serviciousuario;
    }

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal OidcUser principal) {
        if(principal!=null) {

            Usuario usuario=this.serviciousuario.obtenerUsuario(principal.getClaims());
            System.out.println(principal.getClaims());
            model.addAttribute("usuario",usuario);
        }
        return "index";
    }

    //Controlador para Consultar
    @GetMapping("/cliente") // informacion mediante la URL
    public String listar(Model modelo){
        modelo.addAttribute("clientes", sic.listarClientes());
        return ("taclientes");
    }



   /* @GetMapping("/{id}")
    public Cliente consultarporId(@PathVariable("id") Integer id){
        return sic.consultarClientesPorId(id);
    }*/

    /*@GetMapping("cliente/nuevo")
    public String formularioregistro(Model modelo){
        modelo.addAttribute("clienteinsertar",new Cliente());
        return "frmcliente";
    }*/

    @GetMapping("/agregarcliente")
    public String agregarcliente(@ModelAttribute Cliente cliente, Model model){
        model.addAttribute("cliente",new Cliente());
        return "frmcliente";
    }


    @PostMapping("/agregarcliente")
    public String agregar(@ModelAttribute Cliente cliente, Model model){
        sic.guardarClientes(cliente);
        return "redirect:/cliente";
    }


    @GetMapping("cliente/actualizar/{dato}")
    public String formularioActualizar(@PathVariable("dato") Integer dato, Model modelo){
        Cliente cliente=sic.consultarClientesPorId(dato);
        modelo.addAttribute("clienteactualizar", cliente);
        return "frmactualizar";
    }


    @PostMapping("cliente/actualizar")
    public String actualizar(Cliente cli){
        sic.actualizarClientes(cli);
        return "redirect:/cliente";
    }

     @GetMapping("/cliente/eliminar/{id}")
    public String eliminarporId(@PathVariable("id") Integer id){
        sic.eliminarClientesId(id);
        return ("redirect:/cliente");
    }


    /*@PutMapping("cliente/actualizar/{dato}")
    public Cliente actualizar(){

    }*/


    /*@PostMapping ("cliente/guardar") //Informacion segura mediante html
    public String insertar(Cliente cli){
        sic.guardarClientes(cli);
        return "redirect:/cliente";
    }*/


    /*@PutMapping// Actualizacion de informacion
    public Cliente actualizar(@RequestBody Cliente cli){
        return sic.actualizarClientes(cli);
    }*/

    /*@DeleteMapping
    public void eliminar(@RequestBody Cliente cli){
        sic.eliminarClientesId(cli.getDocumento());
    }*/

    /*@DeleteMapping("/{id}")
    public void eliminarporId(@PathVariable Integer id){
        sic.eliminarClientesId(id);
    }

    @PatchMapping("/{id}")
    public Cliente actualizarpor(@PathVariable("id")Integer id, @RequestBody Map<Object,Object> objectMap){
        return sic.actualizarPorId(id,objectMap);
    }*/

}
