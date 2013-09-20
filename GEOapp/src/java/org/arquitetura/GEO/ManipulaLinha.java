/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.arquitetura.GEO;

import java.util.List;
import org.arquitetura.DAO.DAOManipula;
import org.arquitetura.entidades.Base;
import org.arquitetura.entidades.Rua;


public class ManipulaLinha extends DAOManipula<Base> {

    public void insertLine(){
        
            Rua rua = new Rua();
    //		Coordinate p1 = new Coordinate(12, 0);
    //		Coordinate p2 = new Coordinate(15, 20);
    //        Coordinate p3 = new Coordinate(20, 20);
    //		Coordinate[] p = {p1,p2,p3};
            Line line = new Line();
    //        LineString geom = null;

    //		rua.setTheGeom(line.createLinebyCoordinates(p, 4326));

            rua.setNome("rua GF WKT");
            rua.setTheGeom(line.createLineByString("LINESTRING (30 10, 10 30, 40 40)", 4326));

            this.salvar(rua);
    }

    @Override
    public List<Base> getListaEntidades() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
