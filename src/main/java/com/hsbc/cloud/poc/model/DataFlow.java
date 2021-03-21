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
public class DataFlow {
	
	private String id;
	private String resource;
	private String name;	
    private String template_gcs_path;
    private String temp_gcs_location;
    private String network;
    private String inputSubscription;
    private String outputTopic;
    
    
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

	public String getTemplate_gcs_path() {
		return template_gcs_path;
	}

	public void setTemplate_gcs_path(String template_gcs_path) {
		this.template_gcs_path = template_gcs_path;
	}

	public String getTemp_gcs_location() {
		return temp_gcs_location;
	}

	public void setTemp_gcs_location(String temp_gcs_location) {
		this.temp_gcs_location = temp_gcs_location;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getInputSubscription() {
		return inputSubscription;
	}

	public void setInputSubscription(String inputSubscription) {
		this.inputSubscription = inputSubscription;
	}

	public String getOutputTopic() {
		return outputTopic;
	}

	public void setOutputTopic(String outputTopic) {
		this.outputTopic = outputTopic;
	}
		
	@Override
	public String toString() {
		
		return 	"\r\n # Create a dataflow-job" +				
        		"\r\n resource "+ resource +" { " +        		
        		"\r\n name = \""+ name + "\"" +
        		"\r\n template_gcs_path = \""+ template_gcs_path + "\"" +
        		"\r\n temp_gcs_location = \""+ temp_gcs_location + "\"" +
        		"\r\n network = \""+ network + "\"" +
        		"\r\n  parameters = { " +
				"\r\n inputSubscription = \""+ inputSubscription + "\"" +
				"\r\n outputTopic = \""+ outputTopic + "\"" +
				"\r\n  }" +
        		"\r\n }";
        		
		}
	
	
}
