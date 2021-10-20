package com.mindtree.FlightApp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.FlightApp.entity.Flights;
import com.mindtree.FlightApp.exception.ControllerException;
import com.mindtree.FlightApp.exception.ServiceException;
import com.mindtree.FlightApp.repository.FlightsRepo;
import com.mindtree.FlightApp.serviceinter.FlightsService;

@CrossOrigin(origins="*" , allowedHeaders = "*")
@RestController
@RequestMapping("/Flight-App/Flights")
public class FlightsController {
	@Autowired
	FlightsService flightservice;
	
	@PostMapping
	public String addFlights(@RequestBody Flights flight) throws ControllerException
	{
		
		try {
			return flightservice.addFlights(flight);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	@GetMapping
	public List<Flights> getFlightsbyDeparture(@RequestParam(value="departure") @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss") Date time , @RequestParam(value="company") String company) throws ControllerException, ParseException
	{
		try {
			return flightservice.getFlights(time,company);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@GetMapping(value="/company")
	public List<Flights> getFlightsbyCompany(@RequestParam(value="company") String company) throws ControllerException
	{
		try {
			return flightservice.getFlightsbyCompany(company);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	@GetMapping(value="/AllFlights")
	public List<Flights> getAllFlights() throws ControllerException
	{
		try {
			return flightservice.getAllFlights();
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
}
