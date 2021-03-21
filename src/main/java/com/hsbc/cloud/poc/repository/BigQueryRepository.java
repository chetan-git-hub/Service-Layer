package com.hsbc.cloud.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsbc.cloud.poc.model.BigQuery;

@Repository
public interface BigQueryRepository extends JpaRepository<BigQuery, String>{
	
}
