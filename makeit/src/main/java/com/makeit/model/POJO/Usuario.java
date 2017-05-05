/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makeit.model.POJO;

import com.makeit.model.util.Crypt;

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
@Table(name = "usuarios")
public class Usuario implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false, length = 11)
    private int id;

    @Column(name = "dni", nullable = true, length = 9)
    private String dni;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "password", nullable = false, length = 150)
    private String password;

    @Column(name = "nombre", nullable = false, length = 90)
    private String nombre;

    @Column(name = "primer_apellido", nullable = false, length = 90)
    private String primer_apellido;

    @Column(name = "segundo_apellido", nullable = true, length = 90)
    private String segundo_apellido;

    @Column(name = "codigo_postal", nullable = true, length = 8)
    private int codigo_postal;

    @Column(name = "ciudad", nullable = false, length = 60)
    private String ciudad;

    @Column(name = "pais", nullable = false, length = 65)
    private String pais;

    @Column(name = "is_admin", nullable = true)
    private boolean is_admin;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Tema> temas = new ArrayList<Tema>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VotoTemaUsuario> votos = new HashSet<VotoTemaUsuario>();
    /**
     * Constructor por defecto Usuario
     */
    public Usuario() {

    }
    /**
     * Constructor con parametros Usuario
     * @param email String email
     * @param password String contraseña
     * @param nombre String nombre de usuario
     * @param primer_apellido String primer apellido
     * @param ciudad String ciudad
     * @param pais String piais
     */
    public Usuario(String email, String password, String nombre, String primer_apellido, String ciudad, String pais) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.primer_apellido = primer_apellido;
        this.ciudad = ciudad;
        this.pais = pais;
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
     * Get dni
     * @return 
     */
    public String getDni() {
        return dni;
    }
    /**
     * Set dni
     * @param dni 
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
    /**
     * Get Email
     * @return 
     */
    public String getEmail() {
        return email;
    }
    /**
     * Set Email
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Get Password
     * @return 
     */
    public String getPassword() {
        return password;
    }
    /**
     * Set Password
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Get Nombre
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Set Nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Get primer apellido
     * @return 
     */
    public String getPrimer_apellido() {
        return primer_apellido;
    }
    /**
     * Set primer apellido
     * @param primer_apellido 
     */
    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }
    /**
     * Get segundo apellido
     * @return 
     */
    public String getSegundo_apellido() {
        return segundo_apellido;
    }
    /**
     * set segundo apellido
     * @param segundo_apellido 
     */
    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }
    /**
     * Get codigo Postal
     * @return 
     */
    public int getCodigo_postal() {
        return codigo_postal;
    }
    /**
     * set codigo postal
     * @param codigo_postal 
     */
    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }
    /**
     *Get ciudad
     * @return 
     */
    public String getCiudad() {
        return ciudad;
    }
    /**
     * Set ciudad
     * @param ciudad 
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    /**
     * Get pais
     * @return 
     */
    public String getPais() {
        return pais;
    }
    /**
     * Set pais
     * @param pais 
     */
    public void setPais(String pais) {
        this.pais = pais;
    }
    /**
     * get if is admin
     * @return 
     */
    public boolean isIs_admin() {
        return is_admin;
    }
    /**
     * set admin
     * @param is_admin 
     */
    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }
    /**
     * Get Tema's de usuario 
     * @return 
     */
    public List<Tema> getTemas() {
        return temas;
    }
    /**
     * Set Tema's de usuario
     * @param temas 
     */
    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }
    /**
     * Get Voto's de usuairo
     * @return 
     */
    public Set<VotoTemaUsuario> getVotos() {
        return votos;
    }
    /**
     * Set Voto's de usuario
     * @param votos 
     */
    public void setVotos(Set<VotoTemaUsuario> votos) {
        this.votos = votos;
    }
}
