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
import org.architecture.entities.EntidadePadrao;
import org.hibernate.Session;

/**
 *
 * @author satler
 */
public class HandlePolygon extends DAOManipulator<EntidadePadrao>{

    public int insertPolygonbyCoordinates(){
        
        try{
            EntidadePadrao rua = new EntidadePadrao();
    		Coordinate p1 = new Coordinate(12, 0);
    		Coordinate p2 = new Coordinate(15, 20);
            Coordinate p3 = new Coordinate(20, 20);
    		Coordinate[] coords = {p1,p2,p3, p1};
            CoordinateSequence p = new CoordinateArraySequence(coords);
            
            GeoPolygon poligono = new GeoPolygon();
    		rua.setTheGeom(poligono.createPolygonbyCoordinates(coords, 4326));

            rua.setNome("geo polygon coord oracle 11g");

            int resultado = (int) this.saveGEO(rua);
            return resultado;
        }catch(Exception e){
            return 0;
        }
    }
    
    public int insertPolygonbyString(){
        
        try{
            EntidadePadrao rua = new EntidadePadrao();
            GeoPolygon polygon = new GeoPolygon();
            rua.setNome("geo pol String oracle 11g");
            rua.setTheGeom(polygon.createGEOByString("POLYGON((10 10, 20 10, 20 20, 10 20, 10 10),\n" +
                "(13 13, 17 13, 17 17, 13 17, 13 13))", 4326));

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
