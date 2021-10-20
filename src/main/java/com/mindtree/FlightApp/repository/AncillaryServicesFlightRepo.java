package com.mindtree.FlightApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.FlightApp.entity.AncillaryServiceFlight;


@Repository
@Transactional
public interface AncillaryServicesFlightRepo extends JpaRepository<AncillaryServiceFlight, Integer>{
	@Query("SELECT a FROM AncillaryServiceFlight a WHERE a.flight.FlightId = :FlightId")
	public List<AncillaryServiceFlight> findByFlightId(@Param("FlightId") String FlightId);
}
