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
public class BigQuery {
	
	
	private String id;
	private String resource;
	private String dataset_id;	
    private String location;
    private String default_table_expiration_ms;
    private String env;
    
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
	public String getDataset_id() {
		return dataset_id;
	}

	public void setDataset_id(String dataset_id) {
		this.dataset_id = dataset_id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDefault_table_expiration_ms() {
		return default_table_expiration_ms;
	}

	public void setDefault_table_expiration_ms(String default_table_expiration_ms) {
		this.default_table_expiration_ms = default_table_expiration_ms;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	@Override
	public String toString() {
				
		return 	"\r\n # Create a Big Query Dataset" +
        		"\r\n resource "+ resource +" { " +
        		"\r\n dataset_id = \""+ dataset_id + "\"" +
        		"\r\n location = \""+ location + "\"" +
        		"\r\n default_table_expiration_ms = \""+ default_table_expiration_ms + "\"" +
        		"\r\n labels = { " +
        		"\r\n env = \"" + env + "\"" +
        		"\r\n }" +
        		"\r\n }";
		
			}
	
	
}
