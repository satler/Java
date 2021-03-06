/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.architecture.GEO;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.CoordinateSequence;
import com.vividsolutions.jts.geom.impl.CoordinateArraySequence;
import java.util.List;
import org.architecture.DAO.DAOManipulator;
import org.architecture.entities.Base;
import org.architecture.entities.EntidadePadrao;
import org.hibernate.Session;

/**
 *
 * @author satler
 */
public class HandlePoint extends DAOManipulator<EntidadePadrao>{

     public int insertPoint(){
        
        try{
            EntidadePadrao rua = new EntidadePadrao();
            GEOPoint punto = new GEOPoint();
    		rua.setTheGeom(punto.createPoint(22.5, -33.0, 4326));

            rua.setNome("geo ponto coord oracle 11g");

            int resultado = (int) this.saveGEO(rua);
            return resultado;
        }catch(Exception e){
            return 0;
        }
    }
     
    @Override
    public List<EntidadePadrao> getList() {
    
        Session sessao = this.OpenSession();
        List<EntidadePadrao> lista = sessao.createCriteria(EntidadePadrao.class).list();
        this.closeSession();
        return lista;
    }
    
}
