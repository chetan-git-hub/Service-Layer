package com.hsbc.cloud.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsbc.cloud.poc.model.DataFlow;

@Repository
public interface DataFlowRepository extends JpaRepository<DataFlow, String>{
	
}
