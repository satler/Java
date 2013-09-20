/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.architecture.entities;

import com.vividsolutions.jts.geom.Geometry;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "GEOMETRIA")
public class EntidadePadrao extends Base implements Serializable {

    @Id
    @SequenceGenerator(name = "GQO_SEQ", sequenceName = "SEQ_GEO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GQO_SEQ")  
	int id;
    
	private String nome;
	
	@Type(type = "org.hibernate.spatial.GeometryType")
	@Column(name = "GEOM")
	private Geometry theGeom;

	
    @Override
	public int getId() {
		return id;
	}
    @Override
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Geometry getTheGeom() {
		return theGeom;
	}

	public void setTheGeom(Geometry geom) {
		this.theGeom = geom;
	}

}
