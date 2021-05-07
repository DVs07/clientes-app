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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author aldop
 */
@Controller
@RequestMapping("/")
public class ClienteController {
    
    @Autowired
    private IClienteService clienteService;
    
    @Autowired
    private ICiudadService ciudadService;
    
    @GetMapping("views/clientes/listar")
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
    public String guardarCliente(@Valid @ModelAttribute Cliente cliente, 
            BindingResult result, Model model, RedirectAttributes attribute){
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
        attribute.addFlashAttribute("success", "Cliente guardado con exito!");
        return "redirect:/views/clientes/";
    }
    
    @GetMapping("/editar/{id}")
    public String editarCliente(@PathVariable("id") Long idCliente, Model model
            , RedirectAttributes attribute){
        Cliente cliente = null;
        if(idCliente > 0){
            cliente = clienteService.buscarPorId(idCliente);
            if(cliente == null){
                System.out.println("El cliente no existe");
                attribute.addFlashAttribute("error","Error: El ID del cliente no"
                        + " existe!");
                return "redirect:/views/clientes/";
            }
        }else{
            System.out.println("Problemas con el Id");
            attribute.addFlashAttribute("error","Error: ID erroneo");
            return "redirect:/views/clientes/";
        }
        
        List<Ciudad> listaCiudades = ciudadService.listarCiudades();
        
        model.addAttribute("titulo", "Editar Cliente");
        model.addAttribute("cliente", cliente);
        model.addAttribute("ciudades", listaCiudades);
        return "/views/clientes/form-cliente";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable("id") Long idCliente, 
            RedirectAttributes attribute){
        Cliente cliente = null;
        if(idCliente > 0){
            cliente = clienteService.buscarPorId(idCliente);
            if(cliente == null){
                System.out.println("El cliente no existe");
                attribute.addFlashAttribute("error","ATENCIÖN: El ID del cliente no"
                        + " existe!");
                return "redirect:/views/clientes/";
            }
        }else{
            System.out.println("Problemas con el Id.");
            attribute.addFlashAttribute("error","ATENCIÖN: ID erroneo");
            return "redirect:/views/clientes/";
        }
        clienteService.eliminarCliente(idCliente);
        System.out.println("Se elimino el cliente con Id[" + idCliente +"]");
        attribute.addFlashAttribute("warning"," Se elimino el cliente con Id[" + idCliente +"]");
        return "redirect:/views/clientes/";
    }
}



















