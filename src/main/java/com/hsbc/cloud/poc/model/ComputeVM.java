package com.hsbc.cloud.poc.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ComputeVM {
	
	//required parameters
			
    private String id;	
	
    private String resource;
    
    private String name;
	
	private String zone;
	
	private String machine_type;
	
	private String allow_stopping_for_update;
	
	private String tags;
	
	
	private BootDisk bootDisk;
	
	private network_interface networkInterface;
	  
	//private service_account serviceAccount;
	 
	public ComputeVM() {
		super();
	}
	public ComputeVM(String name, String zone, String machine_type, String allow_stopping_for_update, String tags) {
		super();
		this.name = name;
		this.zone = zone;
		this.machine_type = machine_type;
		this.allow_stopping_for_update = allow_stopping_for_update;
		this.tags = tags;
	}
	
	@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
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
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getMachine_type() {
		return machine_type;
	}
	public void setMachine_type(String machine_type) {
		this.machine_type = machine_type;
	}
	public String getAllow_stopping_for_update() {
		return allow_stopping_for_update;
	}
	public void setAllow_stopping_for_update(String allow_stopping_for_update) {
		this.allow_stopping_for_update = allow_stopping_for_update;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	@JsonManagedReference
	@OneToOne(mappedBy = "computeVM", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
	public BootDisk getBootDisk() {
		return bootDisk;
	}
	public void setBootDisk(BootDisk bootDisk) {
		this.bootDisk = bootDisk;
	}

	@JsonManagedReference
	@OneToOne(mappedBy = "computeVM", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
	public network_interface getNetworkInterface() { 
		return networkInterface; 
	}
	
    public void setNetworkInterface(network_interface networkInterface) {
	  this.networkInterface = networkInterface; 
	} 
    
	/*
	 * @JsonManagedReference
	 * 
	 * @OneToOne(mappedBy = "computeVM", cascade = CascadeType.ALL)
	 * 
	 * @PrimaryKeyJoinColumn public service_account getServiceAccount() { return
	 * serviceAccount; } public void setServiceAccount(service_account
	 * serviceAccount) { this.serviceAccount = serviceAccount; }
	 */
	@Override
	public String toString() {
		return "ComputeVM [name=" + name + ", zone=" + zone + ", machine_type=" + machine_type
				+ ", allow_stopping_for_update=" + allow_stopping_for_update + ", tags=" + tags + ", bootDisk="
				+ bootDisk + ", networkInterface=" + networkInterface + "]";
	}
	
    
    
}