/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.architecture.GEO;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.PrecisionModel;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 *
 * @author satler
 */
public class GEO {
    
     public Geometry createGEOByString ( String geometry, int SRID ){
        
        WKTReader fromText = new WKTReader(new GeometryFactory(new 
        PrecisionModel(PrecisionModel.FLOATING), SRID)); 

        Geometry geom = null; 
        try { 
            geom = fromText.read(geometry);
        } catch (ParseException ex) {
            System.out.println("Erro para converter "+ex);
        }
        geom.setSRID(SRID);
        return geom;
    }
     
 
 public void mais() throws MalformedURLException, IOException{
         
         String url = "/media/DaDos/sitios/Java/Rota_Navegacao/Rota_Navegacao.shp";

     }
     
}

     
     
     
    