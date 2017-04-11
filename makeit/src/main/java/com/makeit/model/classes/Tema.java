/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makeit.model.classes;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author razomiah
 */
public class Tema implements Serializable{
    
    private int id;
    private String titulo;
    private String cuerpo;
    private Date fecha_creacion;
    private int autor_id;
    
    public Tema(){
        
    }

    public Tema(int id, String titulo, String cuerpo, Date fecha_creacion, int autor_id) {
        this.id = id;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.fecha_creacion = fecha_creacion;
        this.autor_id = autor_id;
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

    public int getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(int id_usuario) {
        this.autor_id = id_usuario;
    }
    
    
}
