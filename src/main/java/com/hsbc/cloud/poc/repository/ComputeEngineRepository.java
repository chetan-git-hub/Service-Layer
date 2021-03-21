package com.hsbc.cloud.poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsbc.cloud.poc.model.ComputeEngine;

@Repository
public interface ComputeEngineRepository extends JpaRepository<ComputeEngine, String>{
	List<ComputeEngine> findByName(String vmName);
}
