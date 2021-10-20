package com.mindtree.FlightApp.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mindtree.FlightApp.entity.Flights;

@Repository
@Transactional
public interface FlightsRepo extends JpaRepository<Flights, String>{
	@Query("SELECT f FROM Flights f WHERE f.Departure >= :Departure AND f.company = :company")
	public List<Flights> findByDeparture(@Param("Departure") Date Departure, @Param("company") String company);
	
	@Query("SELECT f FROM Flights f WHERE f.FlightId = :FlightId")
	public Flights findByFlightId(@Param("FlightId") String FlightId);
	
	@Query("SELECT f FROM Flights f WHERE f.company = :company")
	public List<Flights> findByCompany(@Param("company") String company);
}
