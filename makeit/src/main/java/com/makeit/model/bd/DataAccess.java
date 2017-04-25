package com.makeit.model.bd;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.makeit.model.bd.HibernateUtil;

/**
 *
 * @author hartbold <ardevolp at gmail dot com>
 */
public class DataAccess<T> {

    private static Session sesion;

    public static Session getSesion() {
        return sesion;
    }

    public static void setSesion(Session ss) {
        sesion = ss;
    }

    /**
     *
     * @throws HibernateException
     */
    protected static void startTransaction() throws HibernateException {
        setSesion(HibernateUtil.getSessionFactory().openSession());
        getSesion().getTransaction().begin();
    }

    /**
     *
     * @throws HibernateException
     */
    protected static void finishTransaction() throws HibernateException {
        getSesion().flush();
        getSesion().getTransaction().commit();
    }

    /**
     * Función encargada de administrar las excepciones producidas en la
     * transacción.
     *
     * @param he
     * @throws HibernateException
     */
    protected static void manageException(HibernateException he) throws HibernateException {
        getSesion().getTransaction().rollback();
        throw new HibernateException("Error en la capa de acceso a datos:", he);
    }

    /**
     *
     * @param data Objeto a persistir.
     * @return Resultado de la operación.
     * @throws HibernateException
     */
    protected static <T> Boolean insert(T data) throws HibernateException {

        Boolean done = false;

        try {
            startTransaction();
            getSesion().saveOrUpdate(data);
            done = true;
            finishTransaction();
        } catch (HibernateException e) {
            manageException(e);
        } finally {
            getSesion().close();
        }

        return done;
    }

    /**
     *
     * @param primary Atributo de la base de datos que es la Pimary Key
     * @param value Id de la entidad a eliminar
     * @param entity
     * @return La entidad que se ha eliminado pasa a estar no persistida pero no
     * la perdemos totalmente.
     * @throws HibernateException
     */
    protected static <T> T delete(String primary, String value, Class<T> entity) throws HibernateException {
        T dummy = null;

        try {
            dummy = (T) get(primary, value, entity);

            startTransaction();
            getSesion().delete(dummy);
            finishTransaction();
        } catch (HibernateException he) {
            manageException(he);
        } finally {
            getSesion().close();
        }

        return dummy;
    }

    /**
     * Función de eliminación simplificada.
     *
     * @param entity
     * @param id Id de la entidad a eliminar.
     * @return
     * @throws HibernateException
     */
    protected static <T> boolean delete(Class<T> entity, int id) throws HibernateException {
        boolean done = false;
        T data = get(entity, id);
        try {
            startTransaction();
            getSesion().delete(data);
            finishTransaction();
            done = true;
        } catch (HibernateException he) {
            manageException(he);
        } finally {
            getSesion().close();
        }

        return done;
    }

    /**
     * Función de búsqueda de una entidad por clave primaria.
     *
     * @param primary Atributo de la base de datos que es la Pimary Key
     * @param value Valor del atributo a buscar
     * @param entity
     * @return
     * @throws HibernateException
     */
    protected static <T> T get(String primary, String value, Class<T> entity) throws HibernateException {
        T dummy = null;
        try {
            startTransaction();

            Query query = getSesion().createQuery("SELECT e FROM " + entity.getName() + " as e WHERE e." + primary + "=:" + primary).setParameter(primary, value);
            dummy = (T) query.uniqueResult();
            finishTransaction();
        } catch (HibernateException he) {
            manageException(he);
        } finally {
            getSesion().close();
        }

        return dummy;
    }

    /**
     *
     * @param entity Clase de la entidad a encontrar
     * @param id Valor de la clave primaria.
     * @return
     * @throws HibernateException
     */
    public static <T> T get(Class<T> entity, int id) throws HibernateException {
        T dummy = null;
        try {
            startTransaction();
            dummy = (T) getSesion().get(entity, id);
            finishTransaction();
        } catch (HibernateException he) {
            manageException(he);
        } finally {
            getSesion().close();
        }

        return dummy;
    }

    /* =========== ESTO ESTÁ VIEJUNO =========== 


	private static SessionFactory factory;
	
	private static Transaction tx;

	public static SessionFactory getFactory() {
		return factory;
	}

	public static void setFactory(SessionFactory fc) {
		factory = fc;
	}

	

	public static Transaction getTx() {
		return tx;
	}

	public static void setTx(Transaction tsc) {
		tx = tsc;
	}

	public static void startTransaction() throws HibernateException {
		setFactory(HibernateUtil.getSessionFactory());
		setSesion(getFactory().openSession());
		setTx(getSesion().beginTransaction());
	}

	public static void finishTransaction() throws HibernateException {
		getTx().commit();
		//getSesion().close();
	}

	public static void manageException(HibernateException he) throws HibernateException {
		getTx().rollback();
		throw new HibernateException("Error en la capa de acceso a datos:", he);
	}

	public static <T> long insert(T data) throws HibernateException {
		long id = -1;

		try {
			startTransaction();
			id = (long) getSesion().save(data);
			finishTransaction();
		} catch (HibernateException e) {
			manageException(e);
		} finally {
			getSesion().close();
		}

		return id;
	}

	public static <T> void update(T data) throws HibernateException {
		try {
			startTransaction();
			getSesion().update(data);
			finishTransaction();
		} catch (HibernateException he) {
			manageException(he);
		} finally {
			getSesion().close();
		}
	}

	public static <T> T delete(T data) throws HibernateException {
		try {
			startTransaction();
			getSesion().delete(data);
			finishTransaction();
		} catch (HibernateException he) {
			manageException(he);
		} finally {
			getSesion().close();
		}

		return data;
	}
	
	public static <T> T get(Class<T> entity,  long id) throws HibernateException {
		T dummy = null;
		try {
			startTransaction();
			dummy = (T) getSesion().get(entity,id);
			finishTransaction();
		} catch (HibernateException he) {
			manageException(he);
		} finally {
			getSesion().close();
		}

		return dummy;
	}
     */
}
