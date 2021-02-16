package com.hsbc.cloud.poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsbc.cloud.poc.model.ComputeVM;
import com.hsbc.cloud.poc.model.BootDisk;


public interface BootDiskRepository extends JpaRepository<BootDisk, String>{
	
}
