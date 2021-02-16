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
public class Subnetwork {
		
	private String id;
	
	private String resource;
	private String name;
	private String ip_cidr_range;
	private String region;
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

	public String getIp_cidr_range() {
		return ip_cidr_range;
	}

	public void setIp_cidr_range(String ip_cidr_range) {
		this.ip_cidr_range = ip_cidr_range;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	@Override
	public String toString() {
		return "Subnetwork [resource=" + resource + ", name=" + name + ", ip_cidr_range=" + ip_cidr_range + ", region="
				+ region + ", network=" + network + "]";
	}
	
	
	
}
