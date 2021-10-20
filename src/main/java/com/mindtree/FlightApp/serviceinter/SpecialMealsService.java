package com.mindtree.FlightApp.serviceinter;

import java.util.List;

import com.mindtree.FlightApp.entity.SpecialMeals;
import com.mindtree.FlightApp.exception.ServiceException;

public interface SpecialMealsService {

	String addMeals(SpecialMeals meals, String flightID)throws ServiceException;

	String updateMeals(SpecialMeals meals, String flightID)throws ServiceException;

	String deleteMeals(int mealid)throws ServiceException;

	List<SpecialMeals> displayMeals(String flightID)throws ServiceException;

}
