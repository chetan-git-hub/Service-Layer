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
public class NaturalLanguageApi {
	
	private String id;
	private String resource;
	private String display_name;	
    private String default_language_code;
    private String supported_language_codes;
    private String time_zone;
    private String description;
	private String enable_logging;
	private String match_mode;	
    private String classification_threshold;
    private String api_version;
    private String tier;
    
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
	
	
	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public String getDefault_language_code() {
		return default_language_code;
	}

	public void setDefault_language_code(String default_language_code) {
		this.default_language_code = default_language_code;
	}

	public String getSupported_language_codes() {
		return supported_language_codes;
	}

	public void setSupported_language_codes(String supported_language_codes) {
		this.supported_language_codes = supported_language_codes;
	}

	public String getTime_zone() {
		return time_zone;
	}

	public void setTime_zone(String time_zone) {
		this.time_zone = time_zone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEnable_logging() {
		return enable_logging;
	}

	public void setEnable_logging(String enable_logging) {
		this.enable_logging = enable_logging;
	}

	public String getMatch_mode() {
		return match_mode;
	}

	public void setMatch_mode(String match_mode) {
		this.match_mode = match_mode;
	}

	public String getClassification_threshold() {
		return classification_threshold;
	}

	public void setClassification_threshold(String classification_threshold) {
		this.classification_threshold = classification_threshold;
	}

	public String getApi_version() {
		return api_version;
	}

	public void setApi_version(String api_version) {
		this.api_version = api_version;
	}

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	@Override
	public String toString() {
			
		return 	"\r\n # Create a Big Query Dataset" +
        		"\r\n resource "+ resource +" { " +
        		"\r\n display_name = \""+ display_name + "\"" +
        		"\r\n default_language_code = \""+ default_language_code + "\"" +
        		"\r\n supported_language_codes = [\""+ supported_language_codes + "\"]" +
        		"\r\n time_zone = \""+ time_zone + "\"" +
        		"\r\n description = \""+ description + "\"" +
        		"\r\n enable_logging = \""+ enable_logging + "\"" +
        		"\r\n match_mode = \""+ match_mode + "\"" +
        		"\r\n classification_threshold = \""+ classification_threshold + "\"" +
        		"\r\n api_version = \""+ api_version + "\"" +
        		"\r\n tier = \""+ tier + "\"" +        		
        		"\r\n }";
		
			}
	
	
}
