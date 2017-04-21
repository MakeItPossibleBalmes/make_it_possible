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
 *
 * @author razomiah
 */
public class DAOCategoria extends DataAccess<Categoria> {

	/**
	 * 
	 * @param categoria
	 * @return Id de la categoría insertada
	 * @throws HibernateException
	 */
	public long insertCategoria(Categoria categoria) throws HibernateException {
		/*
		 * EntityManager manager = BD.getConnexio();
		 * manager.getTransaction().begin(); manager.persist(categoria);
		 * manager.getTransaction().commit(); BD.tancarConnexio();
		 */

		return insert(categoria);
	}

	/**
	 * 
	 * @param id
	 *            Categoría a buscar
	 * @return Categoría encontrada por esa id
	 * @throws HibernateException
	 */
	public Categoria getCategoria(long id) throws HibernateException {
		/*
		 * EntityManager manager = BD.getConnexio(); categoria =
		 * manager.find(Categoria.class, id); BD.tancarConnexio();
		 */

		return get(Categoria.class, id);
	}

	/**
	 * 
	 * @return Lista de todas las categorías
	 * @throws HibernateException
	 */
	public List<Categoria> getAllCategorias() throws HibernateException {
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
			throw he;
		} finally {
			getSesion().close();
		}

		return categorias;
	}
}
