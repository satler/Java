package org.architecture.DAO;

import java.io.Serializable;
import java.util.List;
import org.architecture.entities.Base;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public abstract class DAOManipulator<T extends Base> implements iDAO<T> {

	public abstract List<T> getList();
    
    private  SessionFactory sessionFactory;
    private  Session session = null;
    private  Transaction transaction = null;
    
    public Session OpenSession(){
        this.sessionFactory = this.getSessionFactory();
		this.session = this.sessionFactory.openSession();
		this.transaction = this.session.beginTransaction();
        return this.session;
        
    }
    public void closeSession(){
        this.sessionFactory.close();
    }
    
	@Override
	public T loadGEOEntity( Integer id ) {
        
		for (T entidade : this.getList()) {
			if (entidade.getId() == id) {
				return entidade;
			}
		}
		return null;

	}

	@Override
	public void deleteGEO( Integer id ) {
		T toDelete = this.loadGEOEntity(id);
        System.out.println("chegou "+toDelete );
		if(toDelete != null){
			this.OpenSession();
            this.session.delete(toDelete);
            this.transaction.commit();
            this.closeSession();
		}
	}

	@Override
	public void deleteGEO( T t ) {
        
        this.OpenSession();
        this.session.delete(t);
        this.transaction.commit();
        this.closeSession();

	}

	@Override
	public List<T> listGEO() {
		return this.getList();
	}

	@Override
	public Serializable saveGEO( T t ) {
        this.OpenSession();
        Serializable id = this.session.save(t);
        this.transaction.commit();
        this.closeSession();
        return id;
	}
    
    private static SessionFactory configureSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory;
        ServiceRegistry serviceRegistry;
        serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return configureSessionFactory();

    }

}
