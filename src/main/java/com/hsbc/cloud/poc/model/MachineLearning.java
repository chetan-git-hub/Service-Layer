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
public class MachineLearning {
		
	private String id;
	private String resource;
	private String name;
	private String description;
	private String function;
	private String online_prediction_logging;
	private String online_prediction_console_logging;
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getOnline_prediction_logging() {
		return online_prediction_logging;
	}

	public void setOnline_prediction_logging(String online_prediction_logging) {
		this.online_prediction_logging = online_prediction_logging;
	}

	public String getOnline_prediction_console_logging() {
		return online_prediction_console_logging;
	}

	public void setOnline_prediction_console_logging(String online_prediction_console_logging) {
		this.online_prediction_console_logging = online_prediction_console_logging;
	}

	@Override
	public String toString() {
			
		return 	"\r\n # Create a Container Registry" +
        		"\r\n resource "+ resource +" { " +
        		"\r\n name = \""+ name + "\"" +
        		"\r\n description = \""+ description + "\"" +
        		"\r\n labels { " +
        		"\r\n function = \""+ function + "\"" +        		
        		"\r\n }" +
        		"\r\n online_prediction_logging = \""+ online_prediction_logging + "\"" +
        		"\r\n online_prediction_console_logging = \""+ online_prediction_console_logging + "\"" +
        		"\r\n }";
		}	
	
	
}
