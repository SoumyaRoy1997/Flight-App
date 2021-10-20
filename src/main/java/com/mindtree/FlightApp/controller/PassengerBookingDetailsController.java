package com.mindtree.FlightApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.FlightApp.entity.Passengerbookingdetails;
import com.mindtree.FlightApp.exception.ControllerException;
import com.mindtree.FlightApp.exception.ServiceException;
import com.mindtree.FlightApp.serviceinter.PassengerBookingDetailsService;

@CrossOrigin(origins="*" , allowedHeaders = "*")
@RestController
@RequestMapping("/Flight-App")
public class PassengerBookingDetailsController {
	@Autowired
	PassengerBookingDetailsService bookingservice;
	
	@PostMapping(value="/Booking")
	public String addPassenger(@RequestBody Passengerbookingdetails passenger) throws ControllerException
	{
		try {
			return bookingservice.addPassenger(passenger);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@PutMapping(value="/Admin/Booking")
	public String updatePassengerbyAdmin(@RequestBody Passengerbookingdetails passenger) throws ControllerException
	{
		try {
			return bookingservice.updatePassenger(passenger);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@PutMapping(value="/Booking")
	public String updatePassenger(@RequestBody Passengerbookingdetails passenger) throws ControllerException
	{
		try {
			return bookingservice.updatePassenger(passenger);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	@GetMapping(value="/Admin/{flightID}")
	public List<Passengerbookingdetails> getPassenger(@PathVariable String flightID) throws ControllerException
	{
		try {
			return bookingservice.getPassenger(flightID);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
}
