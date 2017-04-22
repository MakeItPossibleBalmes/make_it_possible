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
@Table(name="temas")
public class Tema implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id",nullable=false,length=11)
	private int id;
	
	@Column(name="titulo",nullable=false)
    private String titulo;
	
	@Column(name="cuerpo",nullable=false,columnDefinition = "TEXT")
    private String cuerpo;
	
	@Column(name="fecha_creacion")
    private Date fecha_creacion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "tema")
	private Set<VotoTemaUsuario> votos=new HashSet<VotoTemaUsuario>();
	

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tema_categoria", joinColumns = { @JoinColumn(name = "tema_id") }, inverseJoinColumns = { @JoinColumn(name = "categoria_id") })
	private Set<Categoria> categorias=new HashSet<Categoria>();
	
    
    public Tema(){
        
    }


	public Tema(int id, String titulo, String cuerpo, Date fecha_creacion, Usuario usuario) {
		this.id = id;
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.fecha_creacion = fecha_creacion;
		this.usuario = usuario;
	}
	public Tema(String titulo, String cuerpo, Date fecha_creacion, Usuario usuario) {
		this.id = id;
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.fecha_creacion = fecha_creacion;
		this.usuario = usuario;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getCuerpo() {
		return cuerpo;
	}


	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}


	public Date getFecha_creacion() {
		return fecha_creacion;
	}


	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Set<VotoTemaUsuario> getVotos() {
		return votos;
	}


	public void setVotos(Set<VotoTemaUsuario> votos) {
		this.votos = votos;
	}


	public Set<Categoria> getCategoria() {
		return categorias;
	}


	public void setCategoria(Set<Categoria> categoria) {
		this.categorias = categoria;
	}


	@Override
	public String toString() {
		return "Tema [id=" + id + ", titulo=" + titulo + ", cuerpo=" + cuerpo + ", fecha_creacion=" + fecha_creacion
				+ ", ]";
	}
	
    
    
}
