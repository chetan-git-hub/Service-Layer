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
public class BootDisk {
	
	
	private String id;	
	private String image;	
    private ComputeVM computeVM;
	

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
    @JoinColumn(name = "VM_id")
	@MapsId
	public ComputeVM getComputeVM() {
		return computeVM;
	}

	public void setComputeVM(ComputeVM computeVM) {
		this.computeVM = computeVM;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "boot_disk { \n initialize_params \n { image=" + image + "\n} \n}";
	}

	
	
}
