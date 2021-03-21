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
public class VPCnetwork {
		
	private String id;
	
	private String resource;
	private String name;
	private String auto_create_subnetworks;
	
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

	public String getAuto_create_subnetworks() {
		return auto_create_subnetworks;
	}

	public void setAuto_create_subnetworks(String auto_create_subnetworks) {
		this.auto_create_subnetworks = auto_create_subnetworks;
	}

	@Override
    public String toString() {
        return "\r\n ## Create a VPC" +
        		"\r\n resource "+ resource +" { " +
                "\r\n name = \"" + name +"\"" +
                "\r\n auto_create_subnetworks = \"" + auto_create_subnetworks +"\"" +
                "\r\n }";
    }

	
}
