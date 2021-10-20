package com.mindtree.FlightApp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.FlightApp.entity.Flights;
import com.mindtree.FlightApp.entity.Passengerbookingdetails;

@Repository
@Transactional
public interface PassengerBookingDetailsRepo extends JpaRepository<Passengerbookingdetails, String>{
	@Query("SELECT b FROM Passengerbookingdetails b WHERE b.bookingID = :bookingID")
	public Passengerbookingdetails findBybookingID(@Param("bookingID") String bookingID);
	
	@Query("SELECT b FROM Passengerbookingdetails b WHERE b.passengerflightdetails.flight.FlightId = :FlightId")
	public List<Passengerbookingdetails> findByFlightId(@Param("FlightId") String FlightId);
	
}
