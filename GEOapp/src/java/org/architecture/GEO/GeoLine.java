/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.architecture.GEO;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.CoordinateSequence;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.PrecisionModel;
import com.vividsolutions.jts.geom.impl.CoordinateArraySequence;

/**
 *
 * @author satler
 */
public class GeoLine extends GEO{
    
    public LineString createLinebyCoordinates( Coordinate[] coordenadas, int SRID){
        
        LineString theGeom;
        PrecisionModel pm = new PrecisionModel(0.1);
		GeometryFactory gf = new GeometryFactory(pm, -1);
		
		CoordinateSequence cs = new CoordinateArraySequence(coordenadas);
		theGeom = new LineString(cs, gf);
		theGeom.setSRID(SRID);
        return theGeom;
    }
        
}
