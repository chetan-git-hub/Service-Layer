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
public class GKECluster {	
	
	private String id;
	private String resourceCluster;
	private String resourceNodePool;
	
	private String cluster_name;	
    private String cluster_location;
    private String remove_default_node_pool;
    private String initial_node_count;
    
    private String node_pool_name;	
    private String node_pool_location;
    private String cluster;
    private String node_count;
    
    private String preemptible;	
    private String machine_type;
    private String service_account;
    private String oauth_scopes;
    
    
    @Id	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
		
	public String getResourceCluster() {
		return resourceCluster;
	}

	public void setResourceCluster(String resourceCluster) {
		this.resourceCluster = resourceCluster;
	}

	public String getResourceNodePool() {
		return resourceNodePool;
	}

	public void setResourceNodePool(String resourceNodePool) {
		this.resourceNodePool = resourceNodePool;
	}

	public String getCluster_name() {
		return cluster_name;
	}

	public void setCluster_name(String cluster_name) {
		this.cluster_name = cluster_name;
	}

	public String getCluster_location() {
		return cluster_location;
	}

	public void setCluster_location(String cluster_location) {
		this.cluster_location = cluster_location;
	}

	public String getRemove_default_node_pool() {
		return remove_default_node_pool;
	}

	public void setRemove_default_node_pool(String remove_default_node_pool) {
		this.remove_default_node_pool = remove_default_node_pool;
	}

	public String getInitial_node_count() {
		return initial_node_count;
	}

	public void setInitial_node_count(String initial_node_count) {
		this.initial_node_count = initial_node_count;
	}

	public String getNode_pool_name() {
		return node_pool_name;
	}

	public void setNode_pool_name(String node_pool_name) {
		this.node_pool_name = node_pool_name;
	}

	public String getNode_pool_location() {
		return node_pool_location;
	}

	public void setNode_pool_location(String node_pool_location) {
		this.node_pool_location = node_pool_location;
	}

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	public String getNode_count() {
		return node_count;
	}

	public void setNode_count(String node_count) {
		this.node_count = node_count;
	}

	public String getPreemptible() {
		return preemptible;
	}

	public void setPreemptible(String preemptible) {
		this.preemptible = preemptible;
	}

	public String getMachine_type() {
		return machine_type;
	}

	public void setMachine_type(String machine_type) {
		this.machine_type = machine_type;
	}

	public String getService_account() {
		return service_account;
	}

	public void setService_account(String service_account) {
		this.service_account = service_account;
	}

	public String getOauth_scopes() {
		return oauth_scopes;
	}

	public void setOauth_scopes(String oauth_scopes) {
		this.oauth_scopes = oauth_scopes;
	}

	@Override
	public String toString() {
			    	    
		return 	"\r\n # Create a GKE Cluster" +
        		"\r\n resource "+ resourceCluster +" { " +
        		"\r\n name = \""+ cluster_name + "\"" +
        		"\r\n location = \""+ cluster_location + "\"" +
        		"\r\n remove_default_node_pool = \""+ remove_default_node_pool + "\"" +
        		"\r\n initial_node_count = \""+ initial_node_count + "\"" +        		
        		"\r\n }" +
        		"\r\n resource "+ resourceNodePool +" { " +
        		"\r\n name = \""+ node_pool_name + "\"" +
        		"\r\n location = \""+ node_pool_location + "\"" +
        		"\r\n cluster = \""+ cluster + "\"" +
        		"\r\n node_count = \""+ node_count + "\"" + 
        		"\r\n node_config { " +
        		"\r\n preemptible = \""+ preemptible + "\"" +
        		"\r\n machine_type = \""+ machine_type + "\"" +
        		"\r\n service_account = \""+ service_account + "\"" +
        		"\r\n oauth_scopes = [\""+ oauth_scopes + "\"]" +
        		"\r\n  }"+
        		"\r\n }";
		
			}
	
	
}
