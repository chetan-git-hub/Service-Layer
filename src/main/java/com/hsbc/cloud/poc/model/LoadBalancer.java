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
public class LoadBalancer {
		
	private String id;
	private String resourceHealthCheck;
	private String resourceBackendService;
	private String resourceForwardingRule;
	
	//Health Check param
	private String provider;
	private String healthCheckName;
	private String check_interval_sec;
	private String timeout_sec;	
	private String port;	
	//Backend Service param
	private String backendServiceName;
    private String health_checks;
    //Forwarding rule param
    private String forwardingRuleName;
    private String load_balancing_scheme;
    private String all_ports;
    private String backend_service;
    
    
    @Id	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResourceHealthCheck() {
		return resourceHealthCheck;
	}

	public void setResourceHealthCheck(String resourceHealthCheck) {
		this.resourceHealthCheck = resourceHealthCheck;
	}

	public String getResourceBackendService() {
		return resourceBackendService;
	}

	public void setResourceBackendService(String resourceBackendService) {
		this.resourceBackendService = resourceBackendService;
	}

	public String getResourceForwardingRule() {
		return resourceForwardingRule;
	}

	public void setResourceForwardingRule(String resourceForwardingRule) {
		this.resourceForwardingRule = resourceForwardingRule;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getHealthCheckName() {
		return healthCheckName;
	}

	public void setHealthCheckName(String healthCheckName) {
		this.healthCheckName = healthCheckName;
	}

	public String getCheck_interval_sec() {
		return check_interval_sec;
	}

	public void setCheck_interval_sec(String check_interval_sec) {
		this.check_interval_sec = check_interval_sec;
	}

	public String getTimeout_sec() {
		return timeout_sec;
	}

	public void setTimeout_sec(String timeout_sec) {
		this.timeout_sec = timeout_sec;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getBackendServiceName() {
		return backendServiceName;
	}

	public void setBackendServiceName(String backendServiceName) {
		this.backendServiceName = backendServiceName;
	}

	public String getHealth_checks() {
		return health_checks;
	}

	public void setHealth_checks(String health_checks) {
		this.health_checks = health_checks;
	}

	public String getForwardingRuleName() {
		return forwardingRuleName;
	}

	public void setForwardingRuleName(String forwardingRuleName) {
		this.forwardingRuleName = forwardingRuleName;
	}

	public String getLoad_balancing_scheme() {
		return load_balancing_scheme;
	}

	public void setLoad_balancing_scheme(String load_balancing_scheme) {
		this.load_balancing_scheme = load_balancing_scheme;
	}

	public String getAll_ports() {
		return all_ports;
	}

	public void setAll_ports(String all_ports) {
		this.all_ports = all_ports;
	}

	public String getBackend_service() {
		return backend_service;
	}

	public void setBackend_service(String backend_service) {
		this.backend_service = backend_service;
	}

	@Override
	public String toString() {
		
					
		return 	"\r\n # Create a LoadBalancer" +
				"\r\n # Create a Forwarding Rule for LoadBalancer" +
        		"\r\n resource "+ resourceForwardingRule +" { " +
        		"\r\n provider = \""+ provider + "\"" +
        		"\r\n name = \""+ forwardingRuleName + "\"" +
        		"\r\n load_balancing_scheme = \""+ load_balancing_scheme + "\"" +
        		"\r\n all_ports = \""+ all_ports + "\"" +
        		"\r\n backend_service = \""+ backend_service + "\"" +
        		"\r\n }" +
        		"\r\n # Create a Backend Service for LoadBalancer" +
        		"\r\n resource "+ resourceBackendService +" { " +
        		"\r\n provider = \""+ provider + "\"" +
        		"\r\n name = \""+ backendServiceName + "\"" +
        		"\r\n health_checks = [\""+ health_checks + "\"]" +
        		"\r\n }" +
        		"\r\n # Create a Health Check for LoadBalancer" +
        		"\r\n resource "+ resourceBackendService +" { " +
        		"\r\n provider = \""+ provider + "\"" +
        		"\r\n name = \""+ backendServiceName + "\"" +
        		"\r\n check_interval_sec = \""+ check_interval_sec + "\"" +
        		"\r\n timeout_sec = \""+ timeout_sec + "\"" +
        		"\r\n tcp_health_check { " +
        		"\r\n port = \""+ port + "\"" +
        		"\r\n  }"+
        		"\r\n }";
		}	
	
}
