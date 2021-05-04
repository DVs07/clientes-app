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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String guardarCliente(@ModelAttribute Cliente cliente){
        
        clienteService.guardarCliente(cliente);
        return "redirect:/views/clientes/";
    }

}



















