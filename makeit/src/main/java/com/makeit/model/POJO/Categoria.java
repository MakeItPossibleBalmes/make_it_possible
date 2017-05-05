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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Clase POJO de Categoria
 * @author razomiah
 */
@Entity
@Table(name = "categorias")
public class Categoria implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    //@Column(name="id",nullable=false,length=11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    //many to many connection 
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "tema_categoria", joinColumns = {
        @JoinColumn(name = "categoria_id")}, inverseJoinColumns = {
        @JoinColumn(name = "tema_id")})
    private Set<Tema> temas = new HashSet<Tema>();
    /**
     * Constructor por defecto de Categoria
     */
    public Categoria() {

    }
    /**
     * Constructor con parametro id,nombre de Categoria
     * @param id int id de Categoria
     * @param nombre String nombre de Categoria
     */
    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    /**
     *  Constructor con parametro nombre de Categoria
     * @param nombre String nombre 
     */
    public Categoria(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Getter id
     * @return 
     */
    public int getId() {
        return id;
    }
    /**
     * Setter id
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Getter nombre
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * setter nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Getter Temas relacionados a Categoria
     * @return 
     */
    public Set<Tema> getTemas() {
        return temas;
    }
    /**
     * Set tems relacionados a Categoria
     * @param temas 
     */
    public void setTemas(Set<Tema> temas) {
        this.temas = temas;
    }

}
