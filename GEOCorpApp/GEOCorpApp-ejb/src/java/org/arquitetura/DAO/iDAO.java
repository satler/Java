/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.arquitetura.DAO;

import org.arquitetura.entidades.Base;
import java.util.List;

public interface iDAO <T extends Base> {
    
    public T carregar(Integer entidade);
	
	public void salvar(T t);
	
	public List<T> listar();
	
	public void excluir(T t);
	
	public void excluir(Integer id);
}
