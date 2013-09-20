/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.arquitetura.GEO;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.CoordinateSequence;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.PrecisionModel;
import com.vividsolutions.jts.geom.impl.CoordinateArraySequence;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

/**
 *
 * @author satler
 */
public class Line {
    
    public LineString createLinebyCoordinates( Coordinate[] coordenadas, int SRID){
        
        LineString theGeom;
        PrecisionModel pm = new PrecisionModel(0.1);
		GeometryFactory gf = new GeometryFactory(pm, -1);
		
		CoordinateSequence cs = new CoordinateArraySequence(coordenadas);
		theGeom = new LineString(cs, gf);
		theGeom.setSRID(SRID);
        return theGeom;
    }
    
    public Geometry createLineByString ( String geometry, int SRID ){
        
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
