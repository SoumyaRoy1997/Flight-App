package com.mindtree.FlightApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.FlightApp.entity.SpecialMeals;
import com.mindtree.FlightApp.exception.ControllerException;
import com.mindtree.FlightApp.exception.ServiceException;
import com.mindtree.FlightApp.serviceinter.SpecialMealsService;

@CrossOrigin(origins="*" , allowedHeaders = "*")
@RestController
@RequestMapping("/Flight-App/Admin/Meals")
public class SpecialMealsController {
	
	@Autowired
	SpecialMealsService mealservice;
	
	@PostMapping(value="/{flightID}")
	public String addMeals(@RequestBody SpecialMeals meals, @PathVariable String flightID) throws ControllerException
	{
		try {
			return mealservice.addMeals(meals,flightID);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@PutMapping(value="/{flightID}")
	public String updateMeals(@RequestBody SpecialMeals meals, @PathVariable String flightID) throws ControllerException
	{
		try {
			return mealservice.updateMeals(meals,flightID);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@DeleteMapping
	public String deleteMeals(@RequestParam(value="mealid") int mealid) throws ControllerException
	{
		try {
			return mealservice.deleteMeals(mealid);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@GetMapping(value="/{flightID}")
	public List<SpecialMeals> displayMeals(@PathVariable String flightID) throws ControllerException
	{
		try {
			return mealservice.displayMeals(flightID);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
}
