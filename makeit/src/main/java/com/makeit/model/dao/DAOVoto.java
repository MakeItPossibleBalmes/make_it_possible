/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makeit.model.dao;

import com.makeit.model.POJO.Tema;
import com.makeit.model.POJO.Usuario;
import com.makeit.model.POJO.VotoTemaUsuario;
import com.makeit.model.bd.BD;
import com.makeit.model.bd.DataAccess;
import java.util.Date;
import javax.persistence.EntityManager;

/**
 *
 * @author razomiah
 */
public class DAOVoto extends DataAccess<VotoTemaUsuario> {

    public static VotoTemaUsuario insertVoto(Usuario usuario, Tema tema) {
    	
        VotoTemaUsuario voto = new VotoTemaUsuario();
        voto.setTema(tema);
        voto.setUsuario(usuario);
        
        insert(voto);
        
        usuario.getVotos().add(voto);
        
        return voto;
    }

    public static void cancelarVoto(Usuario usuario, Tema tema) {
        startTransaction();
        Usuario us = get(Usuario.class,usuario.getId());
        tema.getVotos().remove(us);
        finishTransaction();
    }
}
