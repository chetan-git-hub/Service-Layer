package com.hsbc.cloud.poc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PersistentDisk{

    //private static final long serialVersionUID = -299482035708790402L;
	
	private String id;
	private String data;
	private String resource;
    private String family;
    private String project;
    private String name;
    private String size;
    private String type;
    private String image;
    private String zone;

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
		
    public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    @Override
    public String toString() {
        return "\r\n ## Create a persistent disk" +
                "\r\n data "+data+" {" +
                "\r\n family = \"" + family + "\"" +
                "\r\n project = \"" + project + "\" \r\n }" +
                "\r\n resource "+ resource +" { " +
                "\r\n name= \"" + name + "\"" +
                "\r\n size = " + size +
                "\r\n type = \"" + type + "\"" +
                "\r\n image = \"" +image+ "\"" +
                "\r\n zone = \"" + zone + "\"" +
                "\r\n }";
    }
}
