package com.mindtree.FlightApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.FlightApp.entity.Admin;

@Repository
@Transactional
public interface AdminRepo extends JpaRepository<Admin, String>{
	@Query("SELECT a FROM Admin a WHERE a.companyName = :companyName")
	public Admin findBycompanyName(@Param("companyName") String companyName);
}
