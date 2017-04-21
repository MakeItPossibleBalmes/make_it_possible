package com.makeit.model.bd;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.makeit.model.bd.HibernateUtil;

/**
 * 
 * @author hartbold <ardevolp at gmail dot com>
 */
public class DataAccess<T> {
	private SessionFactory factory;
	private Session sesion;
	private Transaction tx;

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public Session getSesion() {
		return sesion;
	}

	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}

	public Transaction getTx() {
		return tx;
	}

	public void setTx(Transaction tx) {
		this.tx = tx;
	}

	public void startTransaction() throws HibernateException {
		setFactory(HibernateUtil.getSessionFactory());
		setSesion(factory.openSession());
		setTx(sesion.beginTransaction());
	}

	public void finishTransaction() throws HibernateException {
		getTx().commit();
		//getSesion().close();
	}

	public void manageException(HibernateException he) throws HibernateException {
		getTx().rollback();
		throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
	}

	public long insert(T data) throws HibernateException {
		long id = -1;

		try {
			startTransaction();
			id = (long) getSesion().save(data);
			finishTransaction();
		} catch (HibernateException e) {
			manageException(e);
			throw e;
		} finally {
			getSesion().close();
		}

		return id;
	}

	public void update(T data) throws HibernateException {
		try {
			startTransaction();
			getSesion().update(data);
			finishTransaction();
		} catch (HibernateException he) {
			manageException(he);
			throw he;
		} finally {
			getSesion().close();
		}
	}

	public T delete(T data) throws HibernateException {
		try {
			startTransaction();
			getSesion().delete(data);
			finishTransaction();
		} catch (HibernateException he) {
			manageException(he);
			throw he;
		} finally {
			sesion.close();
		}

		return data;
	}
	
	public T get(Class<T> entity,  long id) throws HibernateException {
		T dummy = null;
		try {
			startTransaction();
			dummy = (T) getSesion().get(entity,id);
			finishTransaction();
		} catch (HibernateException he) {
			manageException(he);
			throw he;
		} finally {
			sesion.close();
		}

		return dummy;
	}
}
