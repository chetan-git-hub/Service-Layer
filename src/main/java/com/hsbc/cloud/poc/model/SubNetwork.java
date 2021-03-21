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
public class SubNetwork {
		
	private String id;
	
	private String resource;
	private String name;
	private String ip_cidr_range;
	private String region;
	private String network;
    

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
	        return "\r\n ## Create a subnetwork" +
	        		"\r\n resource "+ resource +" { " +
	                "\r\n name = \"" + name +"\"" +
	                "\r\n ip_cidr_range = \"" + ip_cidr_range +"\"" +
	                "\r\n network = google_compute_network.cloud_ui_poc_network.id" +
	                "\r\n region = \"" + region +"\"" +
	                "\r\n }";
	    }
	
	
}
