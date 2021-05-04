package com.clienteapp.demo.service;

import com.clienteapp.demo.entity.Cliente;
import java.util.List;

public interface IClienteService {
    public List<Cliente> listarClientes();
    public void guardarCliente(Cliente cliente);
    public Cliente buscarPorId(Long id);
    public void eliminarCliente(Long id);
}
