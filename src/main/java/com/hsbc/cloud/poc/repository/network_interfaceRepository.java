package com.hsbc.cloud.poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsbc.cloud.poc.model.ComputeVM;
import com.hsbc.cloud.poc.model.BootDisk;
import com.hsbc.cloud.poc.model.network_interface;


public interface network_interfaceRepository extends JpaRepository<network_interface, Long>{
	
}
