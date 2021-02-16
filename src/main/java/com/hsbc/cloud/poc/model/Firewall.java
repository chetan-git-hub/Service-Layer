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
public class Firewall {
		
	private String id;
	
	private String resource;
	private String name;
	private String network;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "VM_id")	
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

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	@Override
	public String toString() {
		return "VPCnetwork [resource=" + resource + ", name=" + name + ", auto_create_subnetworks="
				+ network + "]";
	}

	
}
