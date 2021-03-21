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
public class Firewall {
		
	private String id;
	
	private String resource;
	private String name;
	private String network;
    private String source_tags;
    private String protocol;
   // private String protocol2;
    private String ports;
	
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

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}
	
    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getPorts() {
        return ports;
    }

    public void setPorts(String ports) {
        this.ports = ports;
    }

    public String getSource_tags() {
        return source_tags;
    }

    public void setSource_tags(String source_tags) {
        this.source_tags = source_tags;
    }

    
    @Override
    public String toString() {
        //String source = Arrays.toString(source_tags);
        //String port = Arrays.toString(ports);
        /*if(null != port){
            port.replace("[", "").replace("]", "");
        }
        if(null != source) {
            //source = source.replace("[", "\"").replace("]", "\"");
        }*/
        return " \r\n ## Create a Firewall" +
                "\r\n resource \"google_compute_firewall\" \"default\" {" +
                "\r\n name = \"" + name +"\"" +
                "\r\n network = \"" + network + "\"" +
                "\r\n source_tags = [\"" + source_tags +"\"]" +
                //"\r\n allow { \r\n protocol =  \""  + protocol1 +"\" \r\n }" +
                "\r\n allow { \r\n protocol =  \""  + protocol +"\" \r\n  ports = "+ ports + "\r\n }" +
                "\r\n }";
    }

	
}
