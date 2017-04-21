/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makeit.model.dao;

import com.makeit.model.bd.BD;
import com.makeit.model.POJO.Tema;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

/**
 *
 * @author razomiah
 */
public class DAOTema {
	/**
	 * Inserta un tema
	 * 
	 * @param tema
	 * @throws Exception
	 */
	public void insertTema(Tema tema) throws Exception {
		EntityManager manager = BD.getConnexio();
		manager.getTransaction().begin();
		manager.persist(tema);
		manager.getTransaction().commit();
		BD.tancarConnexio();
	}

	/**
	 * Busca tema con id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Tema getTema(int id) throws Exception {
		Tema tema = null;
		EntityManager manager = BD.getConnexio();
		tema = manager.find(Tema.class, id);
		BD.tancarConnexio();
		return tema;
	}
	
	/**
	 * Funcion para recibir todos los temas registrados
	 * @return devuelve una lista de temas
	 */
	public List<Tema>getAllTemas(){
		EntityManager manager = BD.getConnexio();
		List<Tema> temas = (List<Tema>) manager.createQuery("FROM Tema").getResultList();
		BD.tancarConnexio();
		return temas;
	}
}
