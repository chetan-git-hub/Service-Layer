package com.hsbc.cloud.poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsbc.cloud.poc.model.ComputeEngine;
import com.hsbc.cloud.poc.model.Connections;
//import com.hsbc.cloud.poc.model.BootDisk;

@Repository
public interface ConnectionsRepository extends JpaRepository<Connections, String>{
	
}
