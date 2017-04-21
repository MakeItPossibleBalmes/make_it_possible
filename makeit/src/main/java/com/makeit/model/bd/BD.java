/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.makeit.model.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author razomiah
 */
public class BD {

	private static EntityManager manager;
	private static EntityManagerFactory  mg = Persistence.createEntityManagerFactory("makeit");

    
    public static EntityManager getConnexio(){
        if (manager == null) {
        	manager = mg.createEntityManager();
        }
        return manager;
    }

    public static void tancarConnexio() {
    	if(manager!=null){
    		manager.close();
    	}
    }

}
