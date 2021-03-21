package com.hsbc.cloud.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsbc.cloud.poc.model.BigQuery;
import com.hsbc.cloud.poc.model.GKECluster;

@Repository
public interface GKEClusterRepository extends JpaRepository<GKECluster, String>{
	
}
