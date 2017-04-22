/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makeit.model.POJO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author razomiah
 */
@Entity
@Table(name="categorias")
public class Categoria implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	//@Column(name="id",nullable=false,length=11)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre",nullable=false)
    private String nombre;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tema_categoria", joinColumns = { @JoinColumn(name = "categoria_id") }, inverseJoinColumns = { @JoinColumn(name = "tema_id") })
	private Set<Tema> temas = new HashSet<Tema>();
    
    public Categoria(){
        
    }
    
    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public Categoria(String nombre){
    	this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Set<Tema> getTemas() {
        return temas;
    }

    public void setTemas(Set<Tema> temas) {
        this.temas = temas;
    }
    
}
