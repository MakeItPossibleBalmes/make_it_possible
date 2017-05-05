/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makeit.model.POJO;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author razomiah
 */
@Entity
@Table(name = "temas")
public class Tema implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false, length = 11)
    private int id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "cuerpo", nullable = false, columnDefinition = "TEXT")
    private String cuerpo;

    @Column(name = "fecha_creacion")
    private Date fecha_creacion;

    //TODO: Quizá hay que cambiarlo a EAGER para que no haya conflicto al haber cerrado la sesion de Hibernate y tal.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "tema", fetch = FetchType.EAGER)
    private Set<VotoTemaUsuario> votos = new HashSet<VotoTemaUsuario>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tema_categoria", joinColumns = {
        @JoinColumn(name = "tema_id")}, inverseJoinColumns = {
        @JoinColumn(name = "categoria_id")})
    private Set<Categoria> categorias = new HashSet<Categoria>();

    /**
     * Constructor por defecto de Tema
     */
    public Tema() {

    }

    /**
     * Constructor con parametros de Tema
     *
     * @param id int id
     * @param titulo String titulo
     * @param cuerpo String cuerpo
     * @param fecha_creacion Date fecha de creacion
     * @param usuario Usuario usuario al que pertenece
     */
    public Tema(int id, String titulo, String cuerpo, Date fecha_creacion, Usuario usuario) {
        this.id = id;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.fecha_creacion = fecha_creacion;
        this.usuario = usuario;
    }

    /**
     * Constructor con parametros de Tema
     *
     * @param titulo String titulo
     * @param cuerpo String cuerpo
     * @param fecha_creacion Date fecha de creacion
     * @param usuario Usuario usaurio al que pertenece
     */
    public Tema(String titulo, String cuerpo, Date fecha_creacion, Usuario usuario) {
        this.id = id;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.fecha_creacion = fecha_creacion;
        this.usuario = usuario;
    }

    /**
     * Constructor con parametros de Tema Cuando se añade un tema la fecha se
     * establecerá en la base de datos automáticamente.
     *
     * @param titulo
     * @param cuerpo
     * @param usuario
     */
    public Tema(String titulo, String cuerpo, Usuario usuario) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.usuario = usuario;
    }
    /**
     * Get id
     * @return 
     */
    public int getId() {
        return id;
    }
    /**
     * Set id
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Get Titulo
     * @return 
     */
    public String getTitulo() {
        return titulo;
    }
    /**
     * Set titulo
     * @param titulo 
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * Get cuerpo
     * @return 
     */
    public String getCuerpo() {
        return cuerpo;
    }
    /**
     * Set cuerpo
     * @param cuerpo 
     */
    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
    /**
     * Get fecha creacion
     * @return 
     */
    public Date getFecha_creacion() {
        return fecha_creacion;
    }
    /**
     * Set fecha creacion
     * @param fecha_creacion 
     */
    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    /**
     * Get Usuario
     * @return 
     */
    public Usuario getUsuario() {
        return usuario;
    }
    /**
     * Set Usuario
     * @param usuario 
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    /**
     * Get Votos
     * @return 
     */
    public Set<VotoTemaUsuario> getVotos() {
        return votos;
    }
    /**
     * Set Votos
     * @param votos 
     */
    public void setVotos(Set<VotoTemaUsuario> votos) {
        this.votos = votos;
    }
    /**
     * Get Categorias
     * @return 
     */
    public Set<Categoria> getCategoria() {
        return categorias;
    }
    /**
     * Set Categorias
     * @param categoria 
     */
    public void setCategoria(Set<Categoria> categoria) {
        this.categorias = categoria;
    }
}
