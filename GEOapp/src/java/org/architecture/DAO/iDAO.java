/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.architecture.DAO;

import java.io.Serializable;
import org.architecture.entities.Base;
import java.util.List;

public interface iDAO <T extends Base> {
    
    public T loadGEOEntitie(Integer entidade);
	
	public Serializable saveGEO(T t);
	
	public List<T> listGEO();
	
	public void deleteGEO(T t);
	
	public void deleteGEO(Integer id);
}
