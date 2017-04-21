/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makeit.model.dao;

import com.makeit.model.bd.BD;
import com.makeit.model.POJO.Tema;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
	public static void insertTema(Tema tema) throws Exception {
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
	public static Tema getTema(int id) throws Exception {
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
	public static List<Tema>getAllTemas(){
		EntityManager manager = BD.getConnexio();
		List<Tema> temas = (List<Tema>) manager.createQuery("FROM Tema").getResultList();
		BD.tancarConnexio();
		return temas;
	}
	
	/**
	 * Consideramos destacados los temas com más de 5 votos y más recientes.
	 * @param total Total de temas a recibir
	 * @return
	 */
	public static List<Tema> getDestacados(int total){
		int limite = 5;
		
		EntityManager manager = BD.getConnexio();
		List<Tema> temas = (List<Tema>) manager.createQuery("FROM Tema ORDER BY fecha_creacion DESC");
		
		List<Tema> destacados = new ArrayList<Tema>();
		for (int i = 0; i < total; i++) {
			Tema t = temas.get(i);
			if(t.getVotos().size() > limite){
				destacados.add(t);
			}
		}
		
		BD.tancarConnexio();
		
		return destacados;
	}
	
	/**
	 * Los temas con más puntos.
	 * @param total
	 * @return
	 */
	public static List<Tema> getMejorValorados(int total){
		List<Tema> temas = getAllTemas();
		
		//Set<Tema> mejorValorados = new D<Tema>();
		Map<Integer, Integer> datos = new HashMap<Integer, Integer>();
		for (int i = 0; i < total; i++) {
			Tema t = temas.get(i);
			datos.put(t.getId(), t.getVotos().size());
		}
		
		return mejorValorados;
		
	}
}
