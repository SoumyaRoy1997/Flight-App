package com.mindtree.FlightApp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.mindtree.FlightApp.entity.Passengerflightdetails;
import com.mindtree.FlightApp.exception.ControllerException;
import com.mindtree.FlightApp.exception.ServiceException;
import com.mindtree.FlightApp.entity.Passengerflightdetails;
import com.mindtree.FlightApp.serviceinter.PassengerFlightDetailsService;

@CrossOrigin(origins="*" , allowedHeaders = "*")
@RestController
@RequestMapping("/Flight-App")
public class PassengerFlightDetailsController {
	@Autowired
	PassengerFlightDetailsService flightserivce;
	
	@PostMapping(value="/Admin/{flightID}")
	public String addPassenger(@RequestBody Passengerflightdetails passenger , @PathVariable String flightID) throws ControllerException
	{
		try {
			return flightserivce.addPassenger(passenger,flightID);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@PutMapping(value="/Admin/{flightID}")
	public String updatePassenger(@RequestBody Passengerflightdetails passenger , @PathVariable String flightID) throws ControllerException
	{
		try {
			return flightserivce.updatePassenger(passenger,flightID);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@GetMapping(value="/{flightID}")
	public List<Passengerflightdetails> displayPassenger(@PathVariable String flightID) throws ControllerException
	{
		try {
			return flightserivce.displayPassenger(flightID);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@GetMapping(value="/Staff/{flightID}/filtercheckin")
	public List<Passengerflightdetails> displayPassengerfiltercheckin(@PathVariable String flightID, @RequestParam(value="filterby") boolean filterby) throws ControllerException
	{
		try {
			return flightserivce.displayPassengerfiltercheckin(flightID, filterby);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	
	
	@GetMapping(value="/Staff/{flightID}/filterwheelchair")
	public List<Passengerflightdetails> displayPassengerfilterwheelchair(@PathVariable String flightID, @RequestParam(value="filterby") boolean filterby) throws ControllerException
	{
		try {
			return flightserivce.displayPassengerfilterwheelchair(flightID, filterby);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@GetMapping(value="/Staff/{flightID}/filterInfant")
	public List<Passengerflightdetails> displayPassengerfilterInfant(@PathVariable String flightID, @RequestParam(value="filterby") boolean filterby) throws ControllerException
	{
		try {
			return flightserivce.displayPassengerfilterInfant(flightID, filterby);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@GetMapping(value="/Staff/{flightID}/filterMeals")
	public List<Passengerflightdetails> displayPassengerfilterMeals(@PathVariable String flightID, @RequestParam(value="filterby") boolean filterby) throws ControllerException
	{
		try {
			return flightserivce.displayPassengerfilterMeals(flightID, filterby);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@GetMapping(value="/Staff/{flightID}/filterAncillary")
	public List<Passengerflightdetails> displayPassengerfilterAncillary(@PathVariable String flightID, @RequestParam(value="filterby") boolean filterby) throws ControllerException
	{
		try {
			return flightserivce.displayPassengerfilterAncillary(flightID, filterby);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@GetMapping(value="/Admin/{flightID}/filterPassport")
	public List<Passengerflightdetails> displayPassengerfilterPassport(@PathVariable String flightID, @RequestParam(value="filterby") boolean filterby) throws ControllerException
	{
		try {
			return flightserivce.displayPassengerfilterPassport(flightID, filterby);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@GetMapping(value="/Admin/{flightID}/filterAddress")
	public List<Passengerflightdetails> displayPassengerfilterAddress(@PathVariable String flightID, @RequestParam(value="filterby") String filterby) throws ControllerException
	{
		try {
			return flightserivce.displayPassengerfilterAddress(flightID, filterby);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@GetMapping(value="/Admin/{flightID}/filterDOB")
	public List<Passengerflightdetails> displayPassengerfilterDOB(@PathVariable String flightID, @RequestParam(value="filterby") @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")  Date filterby) throws ControllerException
	{
		try {
			return flightserivce.displayPassengerfilterDOB(flightID, filterby);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	
}
