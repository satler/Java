/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.architecture.GEO;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.geom.PrecisionModel;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

/**
 *
 * @author satler
 */
public class GeoPolygon {
    
    public Polygon createPolygonbyCoordinates( Coordinate[] coordenadas, int SRID){
        
        Polygon theGeom;
        PrecisionModel pm = new PrecisionModel(0.1);
		GeometryFactory gf = new GeometryFactory(pm, -1);
		
        LinearRing lr = new LinearRing(coordenadas,pm, SRID);
		theGeom = new Polygon(lr, null, gf);
		theGeom.setSRID(SRID);
        return theGeom;
    }
    
    public Geometry createPolygonByString ( String geometry, int SRID ){
        
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
}
