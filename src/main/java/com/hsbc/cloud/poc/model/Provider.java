package com.hsbc.cloud.poc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Provider {

	
	private String id;
	
	private String provider;
		
	private String project;
	private String region;
	
	@Id	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	@Override
    public String toString() {
        return "\r\n ## Create a persistent disk" +               
                "\r\n provider "+ provider +" { " +
                "\r\n project= \"" + project + "\"" +
                "\r\n region = " + region +                
                "\r\n }";
    }
	
}
