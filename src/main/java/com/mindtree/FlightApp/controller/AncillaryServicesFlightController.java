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

import com.mindtree.FlightApp.entity.AncillaryServiceFlight;
import com.mindtree.FlightApp.exception.ControllerException;
import com.mindtree.FlightApp.exception.ServiceException;
import com.mindtree.FlightApp.serviceinter.AncillaryServicesFlight;

@CrossOrigin(origins="*" , allowedHeaders = "*")
@RestController
@RequestMapping("/Flight-App/Admin/AncillaryServices")
public class AncillaryServicesFlightController {
	
	@Autowired
	AncillaryServicesFlight ancillaryservice;
	
	@PostMapping(value="/{flightID}")
	public String addServices(@RequestBody AncillaryServiceFlight Services, @PathVariable String flightID) throws ControllerException
	{
		try {
			return ancillaryservice.addServices(Services,flightID);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@PutMapping(value="/{flightID}")
	public String updateServices(@RequestBody AncillaryServiceFlight Services, @PathVariable String flightID) throws ControllerException
	{
		try {
			return ancillaryservice.updateServices(Services,flightID);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@DeleteMapping
	public String deleteServices(@RequestParam(value="serviceid") int serviceid) throws ControllerException
	{
		try {
			return ancillaryservice.deleteServices(serviceid);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@GetMapping(value="/{flightID}")
	public List<AncillaryServiceFlight> displayServices(@PathVariable String flightID) throws ControllerException
	{
		try {
			return ancillaryservice.displayServices(flightID);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
}
