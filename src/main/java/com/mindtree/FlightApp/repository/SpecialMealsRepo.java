package com.mindtree.FlightApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.FlightApp.entity.SpecialMeals;

@Repository
@Transactional
public interface SpecialMealsRepo extends JpaRepository<SpecialMeals, Integer>{
	
	@Query("SELECT a FROM SpecialMeals a WHERE a.flight.FlightId = :FlightId")
	public List<SpecialMeals> findByFlightId(@Param("FlightId") String FlightId);
	

}
