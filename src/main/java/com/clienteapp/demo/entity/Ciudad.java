/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clienteapp.demo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author aldop
 */
@Entity
@Table(name="ciudades")
public class Ciudad implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(length = 128, nullable = false, unique = true)
    private String nombre_ciudad;

    public Ciudad() {
        super();
    }
    
    public Ciudad(Long id) {
        super();
        this.id = id;
        
    }
    
    public Ciudad(String nombre_ciudad){
        super();
        this.nombre_ciudad = nombre_ciudad;
    }

    public Long getId() {
        return id;
    }

    public String getNombre_ciudad() {
        return nombre_ciudad;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre_ciudad(String nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }

    @Override
    public String toString() {
        return "Ciudad{" + "id=" + id + ", nombre_ciudad=" + nombre_ciudad + '}';
    }

}
