package com.mindtree.FlightApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.FlightApp.entity.SpecialMeals;
import com.mindtree.FlightApp.exception.ServiceException;
import com.mindtree.FlightApp.repository.FlightsRepo;
import com.mindtree.FlightApp.repository.SpecialMealsRepo;
import com.mindtree.FlightApp.serviceinter.SpecialMealsService;

@Service
public class SpecialMealsServiceImpl implements SpecialMealsService{
	
	@Autowired
	SpecialMealsRepo mealsrepo;
	@Autowired
	FlightsRepo flightrepo;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String addMeals(SpecialMeals meals, String flightID) throws ServiceException {
		meals.setFlight(flightrepo.findByFlightId(flightID));
		mealsrepo.save(meals);
		return "Meals Added";
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String updateMeals(SpecialMeals meals, String flightID) throws ServiceException {
		meals.setFlight(mealsrepo.findById(meals.getMealID()).get().getFlight());
		mealsrepo.save(meals);
		return "Meals Updated";
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String deleteMeals(int mealid) throws ServiceException {
		mealsrepo.deleteById(mealid);
		return "Meals Deleted";
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<SpecialMeals> displayMeals(String flightID) throws ServiceException {	
		return mealsrepo.findByFlightId(flightID);
	}

}
