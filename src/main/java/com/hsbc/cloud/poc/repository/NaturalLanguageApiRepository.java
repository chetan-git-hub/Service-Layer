package com.hsbc.cloud.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsbc.cloud.poc.model.BigQuery;
import com.hsbc.cloud.poc.model.NaturalLanguageApi;

@Repository
public interface NaturalLanguageApiRepository extends JpaRepository<NaturalLanguageApi, String>{
	
}
