package com.mindtree.FlightApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.mindtree.FlightApp.entity.RoleMap;

@Transactional
@Repository
public interface RoleMapRepo extends JpaRepository<RoleMap, Integer>{
	
	@Query("SELECT r FROM RoleMap r WHERE r.userID = :userID")
	public RoleMap findByuserID(@Param("userID") String userID);
}
