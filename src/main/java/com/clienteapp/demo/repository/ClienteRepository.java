
package com.clienteapp.demo.repository;

import com.clienteapp.demo.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    
}
