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
public class ServiceAccount {

	@Id
	private String id;
	
	private String resource;
		
	private String account_id;
	
	private String display_name;
	
	/*
	 * @JsonBackReference
	 * 
	 * @OneToOne
	 * 
	 * @MapsId
	 * 
	 * @JoinColumn(name = "VM_id") private ComputeVM computeVM;
	 */
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

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	@Override
	public String toString() {
		return "## Create a Service Network" +
                "\r\n resource \"google_service_account\" \"src_acc_poc\" {" +
                "\r\n account_id=\"" + account_id +"\"" +
                "\r\n display_name=\"" + display_name +"\"" +
                "\r\n }";
	}	
	
	
	/*
	 * public ComputeVM getComputeVM() { return computeVM; }
	 * 
	 * public void setComputeVM(ComputeVM computeVM) { this.computeVM = computeVM; }
	 */
	
	
	
}
