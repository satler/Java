/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.architecture.GEO;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.geom.PrecisionModel;

/**
 *
 * @author satler
 */
public class GeoPolygon extends GEO{
    
    public Polygon createPolygonbyCoordinates( Coordinate[] coordenadas, int SRID){
        
        Polygon theGeom;
        PrecisionModel pm = new PrecisionModel(0.1);
		GeometryFactory gf = new GeometryFactory(pm, -1);
		
        LinearRing lr = new LinearRing(coordenadas,pm, SRID);
		theGeom = new Polygon(lr, null, gf);
		theGeom.setSRID(SRID);
        return theGeom;
    }
    
}
