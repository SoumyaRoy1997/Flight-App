package com.mindtree.FlightApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.FlightApp.entity.Admin;
import com.mindtree.FlightApp.entity.AncillaryServices;

@Repository
@Transactional
public interface AncillaryServicesRepo extends JpaRepository<AncillaryServices, Integer> {
	
	@Query("SELECT a FROM AncillaryServices a WHERE a.passengerflightdetails.passengerID = :passengerID")
	public AncillaryServices findBypassengerID(@Param("passengerID") String passengerID);
}
