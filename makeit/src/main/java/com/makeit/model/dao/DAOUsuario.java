/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makeit.model.dao;

import com.makeit.model.bd.BD;
import com.makeit.model.POJO.Usuario;
import com.makeit.model.bd.DataAccess;
import java.util.Date;
import java.util.List;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.makeit.model.util.Crypt;
import org.hibernate.HibernateException;

/**
 * Data access object for Usuario
 * @author razomiah
 */
public class DAOUsuario extends DataAccess<Usuario> {

    /**
     * Inserta un usuario Se guardará con la contraseña encriptada en SHA256
     *
     * @param usuario
     * @throws Exception
     */
    public static int insertUsuario(Usuario usuario){
        /*usuario.setPassword(Crypt.encripta(usuario.getPassword()));
		EntityManager manager = BD.getConnexio();
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
		BD.tancarConnexio();*/
    	
    	//Pablo - Guardamos contraseña encriptada.
    	usuario.setPassword(Crypt.encripta(usuario.getPassword()));
        return insert(usuario);                    
    }

    /**
     * Busca usuario con id
     *
     * @param id
     * @return
     * @throws Exception
     */
    public static Usuario getUsuario(int id){
        Usuario usuario = null;
        /*EntityManager manager = BD.getConnexio();
		usuario = manager.find(Usuario.class, id);
		BD.tancarConnexio();
		return usuario;*/
        usuario = get(Usuario.class, id);
        return usuario;
    }

    /**
     * Busca usuario con email
     *
     * @param email
     * @return
     * @throws Exception
     */
    public static Usuario getUsuario(String email){
        Usuario usuario = null;
        try {
            startTransaction();
            usuario = (Usuario) getSesion().createQuery("SELECT us FROM Usuario us WHERE us.email = :email").setString("email", email).uniqueResult();
            finishTransaction();
        } catch (HibernateException he) {
            manageException(he);
        } finally {
            getSesion().close();
        }
        return usuario;
    }

    /**
     * Funcion para recibir todos los usuarios registrados
     *
     * @return devuelve una lista de usuarios
     */
    public static List<Usuario> getAllUsuario() {
        /*EntityManager manager = BD.getConnexio();
		List<Usuario> usuarios = (List<Usuario>) manager.createQuery("FROM Usuario").getResultList();
		BD.tancarConnexio();
		return usuarios;*/
        List<Usuario> usuarios = null;
        try {
            startTransaction();
            usuarios = (List<Usuario>) getSesion().createQuery("FROM Usuario").list();
            finishTransaction();
        } catch (HibernateException he) {
            manageException(he);
        } finally {
            getSesion().close();
        }

        return usuarios;
    }
}
