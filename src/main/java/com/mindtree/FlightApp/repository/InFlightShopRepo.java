package com.mindtree.FlightApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.FlightApp.entity.Admin;
import com.mindtree.FlightApp.entity.InFlightShop;

@Repository
@Transactional
public interface InFlightShopRepo extends JpaRepository<InFlightShop, Integer>{
	@Query("SELECT a FROM InFlightShop a WHERE a.flight.FlightId = :FlightId")
	public List<InFlightShop> findByFlightId(@Param("FlightId") String FlightId);
	
}
