/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.clienteapp.demo.controller;

import com.clienteapp.demo.entity.Ciudad;
import com.clienteapp.demo.entity.Cliente;
import com.clienteapp.demo.service.ICiudadService;
import com.clienteapp.demo.service.IClienteService;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author aldop
 */
@Controller
@RequestMapping("/views/clientes")
public class ClienteController {
    
    @Autowired
    private IClienteService clienteService;
    
    @Autowired
    private ICiudadService ciudadService;
    
    @GetMapping("/")
    public String listarClientes(Model model){
        List<Cliente> listaClientes = clienteService.listarClientes();
        model.addAttribute("titulo","Lista de clientes");
        model.addAttribute("clientes" , listaClientes);
        return "/views/clientes/listar";
    }
    
    @GetMapping("/nuevo")
    public String nuevoCliente(Model model){
        Cliente cliente = new Cliente();
        List<Ciudad> listaCiudades = ciudadService.listarCiudades();
        
        model.addAttribute("titulo", "Nuevo Cliente");
        model.addAttribute("cliente", cliente);
        model.addAttribute("ciudades", listaCiudades);
        return "/views/clientes/form-cliente";
    }

    @PostMapping("/guardar")
    public String guardarCliente(@Valid @ModelAttribute Cliente cliente, BindingResult result, Model model){
        /*List<Ciudad> listaCiudades = ciudadService.listarCiudades();
        
        if(result.hasErrors()){
            model.addAttribute("titulo", "Nuevo Cliente");
            model.addAttribute("cliente", cliente);
            model.addAttribute("ciudades", listaCiudades);
            System.out.println("Error al cargar datos en el formulario");
            return "/views/clientes/form-cliente";  
        }*/
        
        clienteService.guardarCliente(cliente);
        System.out.println("Cliente guardado con exito!");
        return "redirect:/views/clientes/";
    }
    
    @GetMapping("/editar/{id}")
    public String editarCliente(@PathVariable("id") Long idCliente, Model model){
        Cliente cliente = clienteService.buscarPorId(idCliente);
        List<Ciudad> listaCiudades = ciudadService.listarCiudades();
        
        model.addAttribute("titulo", "Editar Cliente");
        model.addAttribute("cliente", cliente);
        model.addAttribute("ciudades", listaCiudades);
        return "/views/clientes/form-cliente";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable("id") Long idCliente){
        clienteService.eliminarCliente(idCliente);
        System.out.println("Se elimino el cliente con Id[" + idCliente +"]");
        return "redirect:/views/clientes/";
    }
}



















