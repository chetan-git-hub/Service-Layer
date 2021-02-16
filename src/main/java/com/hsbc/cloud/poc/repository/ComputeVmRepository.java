package com.hsbc.cloud.poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hsbc.cloud.poc.model.ComputeVM;

@Repository
public interface ComputeVmRepository extends JpaRepository<ComputeVM, String>{
	List<ComputeVM> findByName(String vmName);
}
