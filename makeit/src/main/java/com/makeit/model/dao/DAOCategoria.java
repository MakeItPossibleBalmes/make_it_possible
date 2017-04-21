/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makeit.model.dao;

import com.makeit.model.bd.BD;
import com.makeit.model.POJO.Categoria;
import com.makeit.model.POJO.Usuario;
import java.util.List;

import javax.persistence.EntityManager;

/**
 *
 * @author razomiah
 */
public class DAOCategoria {
	/**
	 * Inserta una categoria
	 * 
	 * @param categoria
	 * @throws Exception
	 */
	public static void insertCategoria(Categoria categoria) throws Exception {
		EntityManager manager = BD.getConnexio();
		manager.getTransaction().begin();
		manager.persist(categoria);
		manager.getTransaction().commit();
		BD.tancarConnexio();
	}

	/**
	 * Busca una categoria con id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public static Categoria getCategoria(int id) throws Exception {
		Categoria categoria = null;
		EntityManager manager = BD.getConnexio();
		categoria = manager.find(Categoria.class, id);
		BD.tancarConnexio();
		return categoria;
	}
	
	/**
	 * Funcion para recibir todas las categoria registrados
	 * @return devuelve una lista de categoria
	 */
	public static List<Categoria>getAllCategorias(){
		EntityManager manager = BD.getConnexio();
		List<Categoria> categorias = (List<Categoria>) manager.createQuery("FROM Categoria").getResultList();
		BD.tancarConnexio();
		return categorias;
	}
}
