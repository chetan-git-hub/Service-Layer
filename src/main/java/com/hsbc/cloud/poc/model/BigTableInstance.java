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
public class BigTableInstance {
	
	private String id;
	private String resource;
	private String name;	
    private String cluster_id;
    private String num_nodes;
    private String storage_type;
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

	public String getCluster_id() {
		return cluster_id;
	}

	public void setCluster_id(String cluster_id) {
		this.cluster_id = cluster_id;
	}

	public String getNum_nodes() {
		return num_nodes;
	}

	public void setNum_nodes(String num_nodes) {
		this.num_nodes = num_nodes;
	}

	public String getStorage_type() {
		return storage_type;
	}

	public void setStorage_type(String storage_type) {
		this.storage_type = storage_type;
	}

	public String getPrevent_destroy() {
		return prevent_destroy;
	}

	public void setPrevent_destroy(String prevent_destroy) {
		this.prevent_destroy = prevent_destroy;
	}

	@Override
	public String toString() {
				
		return 	"\r\n # Create a Bigtable Instance" +
        		"\r\n resource "+ resource +" { " +
        		"\r\n name = \""+ name + "\"" +
        		"\r\n cluster { " +
        		"\r\n cluster_id = \"" + cluster_id + "\""+
        		"\r\n num_nodes = \"" + num_nodes + "\"" +
        		"\r\n storage_type = \"" + storage_type + "\"" +
        		"\r\n } " +
        		"\r\n lifecycle { " +
        		"\r\n prevent_destroy = \"" + prevent_destroy + "\"" +
        		"\r\n }" +
        		"\r\n }";
		
			}
	}
	

