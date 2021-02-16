package com.hsbc.cloud.poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsbc.cloud.poc.model.ComputeVM;
import com.hsbc.cloud.poc.model.BootDisk;
import com.hsbc.cloud.poc.model.ServiceAccount;


public interface ServiceAccountRepository extends JpaRepository<ServiceAccount, Long>{
	
}
