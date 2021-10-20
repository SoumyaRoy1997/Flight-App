package com.mindtree.FlightApp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.FlightApp.entity.AncillaryServices;
import com.mindtree.FlightApp.entity.Passengerflightdetails;

@Repository
@Transactional
public interface PassengerFlightDetailsRepo extends JpaRepository<Passengerflightdetails,String>{
	
	@Query("SELECT f FROM Passengerflightdetails f WHERE f.flight.FlightId = :FlightId")
	public List<Passengerflightdetails> findByFlightId(@Param("FlightId") String FlightId);
	
	@Query("SELECT a FROM Passengerflightdetails a WHERE a.passengerID = :passengerID")
	public Passengerflightdetails findBypassengerID(@Param("passengerID") String passengerID);
	
	@Query("SELECT f FROM Passengerflightdetails f WHERE f.wheelchair = :wheelchair AND f.flight.FlightId = :FlightId")
	public List<Passengerflightdetails> findByWheelchair(@Param("wheelchair") Boolean wheelchair , @Param("FlightId") String FlightId);
	
	@Query("SELECT f FROM Passengerflightdetails f WHERE f.infants = :infants AND f.flight.FlightId = :FlightId")
	public List<Passengerflightdetails> findByInfants(@Param("infants") Boolean infants , @Param("FlightId") String FlightId);
	
	@Query("SELECT f FROM Passengerflightdetails f WHERE f.meals = :meals AND f.flight.FlightId = :FlightId")
	public List<Passengerflightdetails> findBymeals(@Param("meals") Boolean meals , @Param("FlightId") String FlightId);
	
	@Query("SELECT f FROM Passengerflightdetails f WHERE f.ancillaryServices = :ancillaryServices AND f.flight.FlightId = :FlightId")
	public List<Passengerflightdetails> findByancillaryServices(@Param("ancillaryServices") Boolean ancillaryServices , @Param("FlightId") String FlightId);
	
	@Query("SELECT f FROM Passengerflightdetails f WHERE f.checkin = :checkin AND f.flight.FlightId = :FlightId")
	public List<Passengerflightdetails> findBycheckin(@Param("checkin") Boolean checkin , @Param("FlightId") String FlightId);
	
	@Query("SELECT f FROM Passengerflightdetails f WHERE f.passengerbookingdetails.passport = :passport AND f.flight.FlightId = :FlightId")
	public List<Passengerflightdetails> findBypassport(@Param("passport") Boolean passport , @Param("FlightId") String FlightId);
	
	@Query("SELECT f FROM Passengerflightdetails f WHERE f.passengerbookingdetails.dob >= :dob AND f.flight.FlightId = :FlightId")
	public List<Passengerflightdetails> findByDOB(@Param("dob") Date dob , @Param("FlightId") String FlightId);
	
	@Query("SELECT f FROM Passengerflightdetails f WHERE f.passengerbookingdetails.address like %:address% AND f.flight.FlightId = :FlightId")
	public List<Passengerflightdetails> findByAddress(@Param("address") String address , @Param("FlightId") String FlightId);
}
