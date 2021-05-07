package com.clienteapp.demo.controller;

import com.clienteapp.demo.entity.Ciudad;
import com.clienteapp.demo.service.ICiudadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("views/ciudades")
public class CiudadController {
    
    @Autowired
    private ICiudadService ciudadService;
    
    @GetMapping("/listar-ciudades")
    public String listarCiudades(Model model){
        List<Ciudad> listaCiudades = ciudadService.listarCiudades();
        model.addAttribute("titulo","Lista de ciudades");
        model.addAttribute("ciudades" , listaCiudades);
        return "views/ciudades/listar";
    }
    
    @GetMapping("/nueva-ciudad")
    public String nuevaCiudad(Model model){
        Ciudad ciudad = new Ciudad();
        model.addAttribute("titulo", "Nueva Ciudad");
        model.addAttribute("ciudad", ciudad);
        return "views/ciudades/form-ciudad";
    }
    
    @PostMapping("/agregar")
    public String guardarCiudad(@ModelAttribute Ciudad ciudad){
        ciudadService.guardarCiudad(ciudad);
        return "redirect:views/ciudades/";
    }
}
