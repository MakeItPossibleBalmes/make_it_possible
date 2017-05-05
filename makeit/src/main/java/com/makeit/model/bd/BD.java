/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makeit.model.bd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Conexion a bd
 *
 * @deprecated
 * @author razomiah
 */
public class BD {

    private static EntityManager manager;
    private static EntityManagerFactory mg = Persistence.createEntityManagerFactory("makeit");

    /**
     * Get the connection of db
     *
     * @return
     */
    public static EntityManager getConnexio() {
        if (manager == null) {
            manager = mg.createEntityManager();
        }
        return manager;
    }

    /**
     * Close db connection
     */
    public static void tancarConnexio() {
        if (manager != null) {
            manager.close();
        }
    }

}
