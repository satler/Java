package org.arquitetura.DAO;

import java.util.List;
import org.arquitetura.entidades.Base;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public abstract class DAOManipula<T extends Base> implements iDAO<T> {

	public abstract List<T> getListaEntidades();
    
    private  SessionFactory sessionFactory;
    private  Session session = null;
    private  Transaction transaction = null;
    
    public void OpenSession(){
        this.sessionFactory = this.getSessionFactory();
		this.session = this.sessionFactory.openSession();
		this.transaction = this.session.beginTransaction();
        
    }
    public void closeSession(){
        this.sessionFactory.close();
    }
    
	@Override
	public T carregar(Integer id) {
		for (T entidade : this.getListaEntidades()) {
			if (entidade.getId() == id) {
				return entidade;
			}
		}
		return null;

	}

	@Override
	public void excluir(Integer id) {
		T entidadeAExcluir = this.carregar(id);
		if(entidadeAExcluir != null){
			this.getListaEntidades().remove(entidadeAExcluir);
		}
	}

	@Override
	public void excluir(T t) {
		this.getListaEntidades().remove(t);

	}

	@Override
	public List<T> listar() {
		return this.getListaEntidades();
	}

	@Override
	public void salvar(T t) {
        System.out.println("passou");
        this.OpenSession();
        this.session.save(t);
        this.transaction.commit();
        this.closeSession();
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
