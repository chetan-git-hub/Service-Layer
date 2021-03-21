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
public class network_interface {
	
	private String id;

	private String subnetwork;
	
	private ComputeEngine computeVM;

	
	public String getSubnetwork() {
		return subnetwork;
	}

	public void setSubnetwork(String subnetwork) {
		this.subnetwork = subnetwork;
	}

	@Id		
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonBackReference
	@OneToOne
    @MapsId
    @JoinColumn(name = "VM_id")
	public ComputeEngine getComputeVM() {
		return computeVM;
	}

	public void setComputeVM(ComputeEngine computeVM) {
		this.computeVM = computeVM;
	}

	@Override
	public String toString() {
		return "network_interface {\n subnetwork=" + subnetwork + "\n}";
	}
	
	
}
