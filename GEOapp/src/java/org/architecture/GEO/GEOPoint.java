/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.architecture.GEO;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.CoordinateSequence;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.geom.PrecisionModel;
import com.vividsolutions.jts.geom.impl.CoordinateArraySequence;

/**
 *
 * @author satler
 */
public class GEOPoint extends GEO{
    
    public Point createPoint( double x, double y, int SRID){
        
        Point theGeom;
        PrecisionModel pm = new PrecisionModel(0.1);
		GeometryFactory gf = new GeometryFactory(pm, -1);
		Coordinate pt = new Coordinate(x, y);
        Coordinate[] coords = {pt};
        CoordinateSequence cs = new CoordinateArraySequence(coords);
		theGeom = new Point(pt, pm, SRID);
        return theGeom;
    }
}
