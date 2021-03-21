package com.hsbc.cloud.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsbc.cloud.poc.model.VPCnetwork;


public interface VPCnetworkRepository extends JpaRepository<VPCnetwork, Long>{
	
}
