package com.hsbc.cloud.poc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class DataStore {
		
	private String id;
	private String resource;
	private String kind;
	private String name;
	private String direction;
    
    @Id		
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
					
		return 	"\r\n # Create a Container Registry" +
        		"\r\n resource "+ resource +" { " +
        		"\r\n kind = \""+ kind + "\"" +
        		"\r\n properties { " +
        		"\r\n name = \""+ name + "\"" +
        		"\r\n direction = \""+ direction + "\"" +
        		"\r\n }" +
        		"\r\n }";
		}	
	
	
}
