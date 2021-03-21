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
public class BigTableTable {
			
	private String id;
	private String resource;
	private String name;	
    private String instance_name;
    private String split_keys;
    private String prevent_destroy;
    
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getInstance_name() {
		return instance_name;
	}

	public void setInstance_name(String instance_name) {
		this.instance_name = instance_name;
	}

	public String getSplit_keys() {
		return split_keys;
	}

	public void setSplit_keys(String split_keys) {
		this.split_keys = split_keys;
	}

	public String getPrevent_destroy() {
		return prevent_destroy;
	}

	public void setPrevent_destroy(String prevent_destroy) {
		this.prevent_destroy = prevent_destroy;
	}

	@Override
	public String toString() {
								
		return 	"\r\n # Create a Bigtable Table" +
        		"\r\n resource "+ resource +" { " +
        		"\r\n name = \""+ name + "\"" +
        		"\r\n instance_name = \"" + instance_name + "\""+
        		"\r\n split_keys = [\"" + split_keys + "\"]" +
        		"\r\n lifecycle { " +
        		"\r\n prevent_destroy = \"" + prevent_destroy + "\"" +
        		"\r\n }" +
        		"\r\n }";
		
			}
	}
	

