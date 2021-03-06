/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makeit.model.dao;

import com.makeit.model.bd.BD;
import com.makeit.model.bd.DataAccess;
import com.makeit.model.POJO.Categoria;
import com.makeit.model.POJO.Usuario;
import java.util.List;

import org.hibernate.HibernateException;

/**
 * Data access object Categoria Class
 *
 * @author razomiah
 */
public class DAOCategoria extends DataAccess<Categoria> {

    /**
     * Insert a Categoria
     *
     * @param categoria Categoria categoria
     * @return Id de la categoría insertada
     * @throws HibernateException
     */
    public static int insertCategoria(Categoria categoria) throws HibernateException {
        /*
		 * EntityManager manager = BD.getConnexio();
		 * manager.getTransaction().begin(); manager.persist(categoria);
		 * manager.getTransaction().commit(); BD.tancarConnexio();
         */

        return insert(categoria);
    }

    /**
     * Delete a Categoria by id
     *
     * @param id
     * @return
     * @throws HibernateException
     */
    public static boolean deleteCategoria(int id) throws HibernateException {
        return delete(Categoria.class, id);
    }

    /**
     * Get a Categoria by id
     *
     * @param id Categoría a buscar
     * @return Categoría encontrada por esa id
     * @throws HibernateException
     */
    public static Categoria getCategoria(int id) throws HibernateException {
        /*
		 * EntityManager manager = BD.getConnexio(); categoria =
		 * manager.find(Categoria.class, id); BD.tancarConnexio();
         */

        //return get("id", String.valueOf(id),Categoria.class);
        return get(Categoria.class, id);
    }

    /**
     * Get All Categories
     *
     * @return Lista de todas las categorías
     * @throws HibernateException
     */
    public static List<Categoria> getAllCategorias() throws HibernateException {
        /*
		 * EntityManager manager = BD.getConnexio(); List<Categoria> categorias
		 * = (List<Categoria>)
		 * manager.createQuery("FROM Categoria").getResultList();
		 * BD.tancarConnexio();
         */
        List<Categoria> categorias = null;
        try {
            startTransaction();
            categorias = getSesion().createQuery("FROM Categoria").list();
            finishTransaction();
        } catch (HibernateException he) {
            manageException(he);
        } finally {
            getSesion().close();
        }

        return categorias;
    }
}
