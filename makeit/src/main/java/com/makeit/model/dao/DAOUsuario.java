/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makeit.model.dao;

import com.makeit.model.bd.BD;
import com.makeit.model.POJO.Tema;
import com.makeit.model.POJO.Usuario;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author razomiah
 */
public class DAOUsuario {
//	@PersistenceContext
	private static EntityManager manager;
	private static EntityManagerFactory  mg = Persistence.createEntityManagerFactory("makeit");

	public static void main(String[] args) {
		
		manager = mg.createEntityManager();
		Usuario usu=manager.find(Usuario.class, 2);
		Tema tema=new Tema("Rajoy","PP corrupcion",new Date(),usu);
		manager.getTransaction().begin();
		//manager.persist(tema);
		manager.getTransaction().commit();
		List<Usuario> u = (List<Usuario>) manager.createQuery("FROM Usuario").getResultList();
		for(Usuario use: u){
			System.out.println(use.getTemas());
			System.out.println(use);
		}
		System.out.println("hay " + u.size() + " Usuario");
		manager.close();
	}
}
