package com.hsbc.cloud.poc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DBInstance {

    //private static final long serialVersionUID = -299482035708790406L;
	private String id;	
	private String resource;
	private String resourceSqlDatabase;
	private String resourceRandomPassword;
	private String resourceSqlUser;
	
    private String dbinstancename;
    private String dbversion;
    private String tier;
    private String deletion_protection;
    private String sqldbname;
    private String sqldbinstance;
    private String passwordlength;
    private String passwordspecial;
    private String passwordoverridespecial;
    private String sqlusername;
    private String sqluserinstance;
    private String sqluserhost;
    private String sqluserpassword;

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

	public String getResourceSqlDatabase() {
		return resourceSqlDatabase;
	}
	public void setResourceSqlDatabase(String resourceSqlDatabase) {
		this.resourceSqlDatabase = resourceSqlDatabase;
	}
	public String getResourceRandomPassword() {
		return resourceRandomPassword;
	}
	public void setResourceRandomPassword(String resourceRandomPassword) {
		this.resourceRandomPassword = resourceRandomPassword;
	}
	public String getResourceSqlUser() {
		return resourceSqlUser;
	}
	public void setResourceSqlUser(String resourceSqlUser) {
		this.resourceSqlUser = resourceSqlUser;
	}
	public String getDbinstancename() {
        return dbinstancename;
    }

    public void setDbinstancename(String dbinstancename) {
        this.dbinstancename = dbinstancename;
    }

    public String getDbversion() {
        return dbversion;
    }

    public void setDbversion(String dbversion) {
        this.dbversion = dbversion;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getDeletion_protection() {
        return deletion_protection;
    }

    public void setDeletion_protection(String deletion_protection) {
        this.deletion_protection = deletion_protection;
    }

    public String getSqldbname() {
        return sqldbname;
    }

    public void setSqldbname(String sqldbname) {
        this.sqldbname = sqldbname;
    }

    public String getSqldbinstance() {
        return sqldbinstance;
    }

    public void setSqldbinstance(String sqldbinstance) {
        this.sqldbinstance = sqldbinstance;
    }

    public String getPasswordlength() {
        return passwordlength;
    }

    public void setPasswordlength(String passwordlength) {
        this.passwordlength = passwordlength;
    }

    public String getPasswordspecial() {
        return passwordspecial;
    }

    public void setPasswordspecial(String passwordspecial) {
        this.passwordspecial = passwordspecial;
    }

    public String getPasswordoverridespecial() {
        return passwordoverridespecial;
    }

    public void setPasswordoverridespecial(String passwordoverridespecial) {
        this.passwordoverridespecial = passwordoverridespecial;
    }

    public String getSqlusername() {
        return sqlusername;
    }

    public void setSqlusername(String sqlusername) {
        this.sqlusername = sqlusername;
    }

    public String getSqluserinstance() {
        return sqluserinstance;
    }

    public void setSqluserinstance(String sqluserinstance) {
        this.sqluserinstance = sqluserinstance;
    }

    public String getSqluserhost() {
        return sqluserhost;
    }

    public void setSqluserhost(String sqluserhost) {
        this.sqluserhost = sqluserhost;
    }

    public String getSqluserpassword() {
        return sqluserpassword;
    }

    public void setSqluserpassword(String sqluserpassword) {
        this.sqluserpassword = sqluserpassword;
    }
    
    @Override
    public String toString() {
        return "\r\n # Create a SQL Database and DB instance" +
                "\r\n resource \"google_sql_database_instance\" \"db_instance\" {" +
                "\r\n name = \"" + dbinstancename + "\"" +
                "\r\n database_version = \"" + dbversion + "\" \r\n " +
                "\r\n settings { \r\n tier = \"" + tier + "\" \r\n }" +
                "\r\n  deletion_protection = \"" + deletion_protection + "\" \r\n }" +
                "\r\n resource \"google_sql_database\" \"database\" { \r\n name = \"" + sqldbname + "\"" +
                "\r\n instance=" + sqldbinstance + "\r\n }" +
                "\r\n resource \"random_password\" \"password\" { \r\n length = " + passwordlength +
                "\r\n special = " + passwordspecial +
                "\r\n override_special = \"" + passwordoverridespecial + "\" \r\n }" +
                "\r\n resource \"google_sql_user\" \"users\" { \r\n name = \"" + sqlusername + "\"" +
                "\r\n instance = " + sqluserinstance +
                "\r\n host = \"" + sqluserhost + "\"" +
                "\r\n password = " + sqluserpassword +
                "\r\n }";
    }
    
}
