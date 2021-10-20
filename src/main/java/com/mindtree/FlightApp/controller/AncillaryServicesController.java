package com.mindtree.FlightApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.FlightApp.entity.AncillaryServices;
import com.mindtree.FlightApp.exception.ControllerException;
import com.mindtree.FlightApp.exception.ServiceException;
import com.mindtree.FlightApp.serviceinter.AncillaryService;

@CrossOrigin(origins="*" , allowedHeaders = "*")
@RestController
@RequestMapping("/Flight-App/Admin/AncillaryService")
public class AncillaryServicesController {
	
	@Autowired
	AncillaryService ancillaryservice;
	
	@PostMapping(value="/{passengerID}")
	public String addServices(@RequestBody AncillaryServices services , @PathVariable String passengerID) throws ControllerException
	{
		try {
			return ancillaryservice.addServices(services,passengerID);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@PutMapping(value="/{passengerID}")
	public String updateServices(@RequestBody AncillaryServices services , @PathVariable String passengerID) throws ControllerException
	{
		try {
			return ancillaryservice.updateServices(services,passengerID);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	@GetMapping(value="/{passengerID}")
	public AncillaryServices displayServices(@PathVariable String passengerID) throws ControllerException
	{
		try {
			return ancillaryservice.displayServices(passengerID);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@DeleteMapping(value="/{passengerID}")
	public String deleteServices(@PathVariable String passengerID) throws ControllerException
	{
		try {
			return ancillaryservice.deleteServices(passengerID);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
}
