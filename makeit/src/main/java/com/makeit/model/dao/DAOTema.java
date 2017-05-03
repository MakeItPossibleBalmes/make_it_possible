/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makeit.model.dao;

import com.makeit.model.bd.BD;
import com.makeit.model.POJO.Tema;
import com.makeit.model.bd.DataAccess;
import com.makeit.model.comparables.TemaFecha;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import org.hibernate.HibernateException;

/**
 * Data access object for Tema
 *
 * @author razomiah
 */
public class DAOTema extends DataAccess<Tema> {

    /**
     * Inserta un tema
     *
     * @param tema
     * @throws Exception
     */
    public static int insertTema(Tema tema) {
        /*EntityManager manager = BD.getConnexio();
		manager.getTransaction().begin();
		manager.persist(tema);
		manager.getTransaction().commit();
		BD.tancarConnexio();*/

        return insert(tema);
    }

    /**
     * Get las insseted Tema iserted in db
     *
     * @return
     */
    public static Tema getLastInserted() {
        int lastId = -1;
        try {
            startTransaction();
            lastId = (int) getSesion().createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult();
            finishTransaction();
        } catch (HibernateException he) {
            manageException(he);
        } finally {
            getSesion().close();
        }

        return getTema(lastId);
    }

    /**
     * Busca tema con id
     *
     * @param id
     * @return
     * @throws Exception
     */
    public static Tema getTema(int id) {
        /*Tema tema = null;
		EntityManager manager = BD.getConnexio();
		tema = manager.find(Tema.class, id);
		BD.tancarConnexio();
		return tema;*/

        return get(Tema.class, id);
    }

    /**
     * Funcion para recibir todos los temas registrados
     *
     * @return devuelve una lista de temas
     */
    public static List<Tema> getAllTemas() {
        /*EntityManager manager = BD.getConnexio();
		List<Tema> temas = (List<Tema>) manager.createQuery("FROM Tema").getResultList();
		BD.tancarConnexio();
		return temas;*/
        List<Tema> temas = null;
        try {
            startTransaction();
            temas = (List<Tema>) getSesion().createQuery("FROM Tema ORDER BY fecha_creacion DESC").list();
            finishTransaction();
        } catch (HibernateException he) {
            manageException(he);
        } finally {
            getSesion().close();
        }

        return temas;
    }

    /**
     * Consideramos destacados los temas com más de 5 votos y más recientes. El
     * número de votos por el que filtramos se especifica en <limite>
     *
     * @param total Temas que va a devolver
     * @return
     */
    public static List<Tema> getDestacados(int total) {
        final int limite = 0;

        List<Tema> temas = getAllTemas();
        if (total > temas.size()) {
            total = temas.size();
        }

        List<Tema> destacados = new ArrayList<Tema>();
        for (int i = 0; i < total; i++) {
            Tema t = temas.get(i);
            if (t.getVotos().size() >= limite) {
                destacados.add(t);
            }
        }

        return destacados;
    }

    /**
     * Los temas con más puntos.
     *
     * @param total
     * @return
     */
    public static List<Tema> getMejorValorados(int total) {
        List<Tema> temas = getAllTemas();
        if (total > temas.size()) {
            total = temas.size();
        }

        //TODO:Recoger el número de votos por cada tema. Ordenarlos de mayor a menor y devolver los temas. (Buscando por la key)
        //Set<Tema> mejorValorados = new D<Tema>();
        Map<Integer, Integer> datos = new HashMap<Integer, Integer>();
        for (int i = 0; i < total; i++) {
            Tema t = temas.get(i);
            datos.put(t.getId(), t.getVotos().size());
        }
        return temas;

    }

    /**
     * Get Temas ordenados por fecha
     *
     * @return
     */
    public static TreeSet<Tema> getRecientes() {
        //Utilizamos el comparator para establecer el orden.
        TreeSet<Tema> temas = new TreeSet<Tema>(new TemaFecha());
        Iterator i = getAllTemas().iterator();
        Tema t = null;
        while (i.hasNext()) {
            t = (Tema) i.next();
            temas.add(t);
        }
        return temas;
    }
}
