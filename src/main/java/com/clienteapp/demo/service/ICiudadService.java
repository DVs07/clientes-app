package com.clienteapp.demo.service;

import com.clienteapp.demo.entity.Ciudad;
import java.util.List;

public interface ICiudadService {
    List<Ciudad> listarCiudades();
    public void guardarCiudad(Ciudad ciudad);
}
