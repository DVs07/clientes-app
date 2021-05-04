package com.clienteapp.demo.service;

import com.clienteapp.demo.entity.Ciudad;
import com.clienteapp.demo.repository.CiudadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CiudadServiceImpl implements ICiudadService{

    @Autowired
    private CiudadRepository ciudadRepository;
    
    @Override
    public List<Ciudad> listarCiudades() {
        
        return (List<Ciudad>)ciudadRepository.findAll();
    }
    
}
