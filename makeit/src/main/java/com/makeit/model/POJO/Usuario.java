/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makeit.model.POJO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author razomiah
 */
@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name="id",nullable=false,length=11)
    private int id;
	
    @Column(name="dni",nullable=true,length=9)
    private String dni;
    
    @Column(name="email",nullable=false,unique=true,length=150)
    private String email;
    
    @Column(name="password",nullable=false,length=150)
    private String password;
    
    @Column(name="nombre",nullable=false,length=90)
    private String nombre;
    
    @Column(name="primer_apellido",nullable=false,length=90)
    private String primer_apellido;
    
    @Column(name="segundo_apellido",nullable=true,length=90)
    private String segundo_apellido;
    
    @Column(name="codigo_postal",nullable=true,length=8)
    private int codigo_postal;
    
    @Column(name="ciudad",nullable=false,length=60)
    private String ciudad;
    
    @Column(name="pais",nullable=false,length=65)
    private String pais;
    
    @Column(name="is_admin",nullable=true)
    private boolean is_admin;
    
    @OneToMany(mappedBy="usuario",cascade=CascadeType.ALL)
    private List<Tema> temas= new ArrayList<Tema>();
    
    
    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VotoTemaUsuario> votos=new HashSet<VotoTemaUsuario>();
    
    

    public Usuario() {

    }

    public Usuario(String email, String password, String nombre, String primer_apellido, String ciudad, String pais) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.primer_apellido = primer_apellido;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public int getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }
    
    

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}
	

	public Set<VotoTemaUsuario> getVotos() {
		return votos;
	}

	public void setVotos(Set<VotoTemaUsuario> votos) {
		this.votos = votos;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", dni=" + dni + ", email=" + email + ", password=" + password + ", nombre="
				+ nombre + ", primer_apellido=" + primer_apellido + ", segundo_apellido=" + segundo_apellido
				+ ", codigo_postal=" + codigo_postal + ", ciudad=" + ciudad + ", pais=" + pais + ", is_admin="
				+ is_admin + "]";
	}
    

}
