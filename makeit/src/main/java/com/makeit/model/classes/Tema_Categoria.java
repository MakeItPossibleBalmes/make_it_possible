/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makeit.model.classes;

/**
 *
 * @author razomiah
 */
public class Tema_Categoria {
    
    private int id;
    private int id_tema;
    private int id_categoria;
    
    public Tema_Categoria(){
        
    }

    public Tema_Categoria(int id, int id_tema, int id_categoria) {
        this.id = id;
        this.id_tema = id_tema;
        this.id_categoria = id_categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_tema() {
        return id_tema;
    }

    public void setId_tema(int id_tema) {
        this.id_tema = id_tema;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    
    
    
}
