package com.makeit.model.bd;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author hartbold <ardevolp at gmail dot com>
 */
public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	
	static {
		try{
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (HibernateException he){
			System.out.println("Error al iniciar la sesion Hibernate: "+he.getMessage());
			throw new ExceptionInInitializerError(he);
		}
	}
	
	public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
