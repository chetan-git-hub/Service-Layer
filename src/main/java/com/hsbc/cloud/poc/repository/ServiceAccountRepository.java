package com.hsbc.cloud.poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsbc.cloud.poc.model.ServiceAccount;

@Repository
public interface ServiceAccountRepository extends JpaRepository<ServiceAccount, Long>{
	
}
