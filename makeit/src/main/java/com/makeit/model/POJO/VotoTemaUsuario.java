package com.makeit.model.POJO;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "voto")
public class VotoTemaUsuario implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false, length = 11)
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "tema_id")
    private Tema tema;

    @Column(name = "fecha_creacion")
    private Date fecha_creacion;

    /**
     * Constructor por defecto de Voto Tema Usuario
     */
    public VotoTemaUsuario() {

    }

    /**
     * Get id
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Set id
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get Usuario
     *
     * @return
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * set Usuario
     *
     * @param usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Get Tema
     *
     * @return
     */
    public Tema getTema() {
        return tema;
    }

    /**
     * Set Tema
     *
     * @param tema
     */
    public void setTema(Tema tema) {
        this.tema = tema;
    }

    /**
     * Get Fecha Creacion
     *
     * @return
     */
    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    /**
     * Get Fecha Creacion
     *
     * @param fecha_creacion
     */
    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
}
