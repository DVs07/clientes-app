
package com.clienteapp.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author aldoruiz
 */
@Controller
public class HomeController {
    
    @GetMapping({"/","/home","index"})
    public String index(){
        return "home";
    }
}
