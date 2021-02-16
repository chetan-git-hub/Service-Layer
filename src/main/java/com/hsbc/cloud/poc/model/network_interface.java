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
	
	private ComputeVM computeVM;

	
	public String getSubnetwork() {
		return subnetwork;
	}

	public void setSubnetwork(String subnetwork) {
		this.subnetwork = subnetwork;
	}

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "VM_id")	
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
	public ComputeVM getComputeVM() {
		return computeVM;
	}

	public void setComputeVM(ComputeVM computeVM) {
		this.computeVM = computeVM;
	}

	@Override
	public String toString() {
		return "network_interface {\n subnetwork=" + subnetwork + "\n}";
	}
	
	
}
