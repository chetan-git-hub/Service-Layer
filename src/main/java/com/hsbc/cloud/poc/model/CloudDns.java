package com.hsbc.cloud.poc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CloudDns {

    //private static final long serialVersionUID = -299482035708790408L;
	private String id;	
	private String resource;
	private String managedResource;
	
	private String name;
	private String dns_name;
	private String managed_name;       
    private String managed_zone;
    private String type;
    private String rrdatas;
    private String ttl;

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
	
	public String getManagedResource() {
		return managedResource;
	}
	public void setManagedResource(String managedResource) {
		this.managedResource = managedResource;
	}
	public String getManaged_name() {
        return managed_name;
    }

    public void setManaged_name(String managed_name) {
        this.managed_name = managed_name;
    }

    public String getDns_name() {
        return dns_name;
    }

    public void setDns_name(String dns_name) {
        this.dns_name = dns_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManaged_zone() {
        return managed_zone;
    }

    public void setManaged_zone(String managed_zone) {
        this.managed_zone = managed_zone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRrdatas() {
        return rrdatas;
    }

    public void setRrdatas(String rrdatas) {
        this.rrdatas = rrdatas;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }
    

    @Override
    public String toString() {
        return "\r\n # Create a Cloud DNS" +
                "\r\n resource \"google_dns_managed_zone\" \"example\" { " +
                "\r\n name = \""+managed_name + "\"" +
                "\r\n dns_name = \""+dns_name + "\" \r\n }" +
                "\r\n resource \"google_dns_record_set\" \"example\" {" +
                "\r\n managed_zone =" + managed_zone  +
                "\r\n name = \"" + name + "\"" +
                "\r\n type = \"" + type + "\"" +
                "\r\n rrdatas = [\"" +rrdatas + "\"]" +
                "\r\n ttl = " + ttl +
                "\r\n}";
    }
}
