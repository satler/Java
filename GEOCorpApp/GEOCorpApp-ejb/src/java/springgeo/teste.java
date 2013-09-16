/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package springgeo;

import org.arquitetura.DAO.DAOSpringConnect;
import org.arquitetura.GEO.Line;
import org.arquitetura.entidades.Rua;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author satler
 */
public class teste {
    
    public boolean testar(){
   
                ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/conf.xml");

        DAOSpringConnect banco = (DAOSpringConnect) ctx.getBean("banco_dados");

            Rua rua = new Rua();
    //		Coordinate p1 = new Coordinate(12, 0);
    //		Coordinate p2 = new Coordinate(15, 20);
    //        Coordinate p3 = new Coordinate(20, 20);
    //		Coordinate[] p = {p1,p2,p3};
            Line line = new Line();
    //        LineString geom = null;

    //		rua.setTheGeom(line.createLinebyCoordinates(p, 4326));

            rua.setNome("rua Spring WKT3");
            rua.setTheGeom(line.createLineByString("LINESTRING (30 10, 10 30, 40 40)", 4326));

            banco.salvar(rua);
            
            return true;
    }
}
