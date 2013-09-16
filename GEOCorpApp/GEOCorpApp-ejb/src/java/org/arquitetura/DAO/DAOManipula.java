package org.arquitetura.DAO;

import java.util.List;
import org.arquitetura.entidades.Base;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class DAOManipula<T extends Base> implements iDAO<T> {

	public abstract List<T> getListaEntidades();
    
	private SessionFactory sessionFactory; 
	private Session sessao; 
	private Transaction transacao;
 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.sessao = sessionFactory.openSession();
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
        
        if(!sessao.isOpen()) {
				sessao = sessionFactory.openSession();
			}
			transacao = sessao.beginTransaction();
			sessao.save(t);
			transacao.commit();
	}

}
