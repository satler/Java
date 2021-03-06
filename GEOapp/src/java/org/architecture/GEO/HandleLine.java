/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.architecture.GEO;

import com.vividsolutions.jts.geom.Coordinate;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import org.architecture.DAO.DAOManipulator;
import org.architecture.entities.EntidadePadrao;
import org.hibernate.Session;


public class HandleLine extends DAOManipulator<EntidadePadrao>{
    
    public int insertLinebyCoordinates(){
        
        try{
            EntidadePadrao rua = new EntidadePadrao();
    		Coordinate p1 = new Coordinate(12, 0);
    		Coordinate p2 = new Coordinate(15, 20);
            Coordinate p3 = new Coordinate(20, 20);
    		Coordinate[] p = {p1,p2,p3};
            GeoLine line = new GeoLine();

    		rua.setTheGeom(line.createLinebyCoordinates(p, 4326));

            rua.setNome("geo soordinates oracle 11g");
//            rua.setTheGeom(line.createLineByString("LINESTRING (30 10, 10 30, 40 40)", 4326));

            int resultado = (int) this.saveGEO(rua);
            return resultado;
        }catch(Exception e){
            return 0;
        }
    }
    
    
    public int insertLinebyString(){
        
        try{
            EntidadePadrao rua = new EntidadePadrao();
            GeoLine line = new GeoLine();
            rua.setNome("geo String oracle 11g");
            rua.setTheGeom(line.createGEOByString("LINESTRING (30 10, 10 30, 40 40)", 4326));

            int resultado = (int) this.saveGEO(rua);
            return resultado;
        }catch(Exception e){
            return 0;
        }
    }
    
    public int deleteLine( Integer ID ){
        
        try{
            this.deleteGEO( ID );
            return 1;
        }catch(Exception e){
            return 0;
        }
    }
    
    public String convertGEO( int id ) throws MalformedURLException, IOException{
        
         GeoLine linha = new GeoLine();
         linha.mais();
         return null;
    }

    @Override
    public List<EntidadePadrao> getList() {
        
        Session sessao = this.OpenSession();
        List<EntidadePadrao> lista = sessao.createCriteria(EntidadePadrao.class).list();
        this.closeSession();
        return lista;
    }
    
}
