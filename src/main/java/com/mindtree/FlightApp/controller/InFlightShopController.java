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

import com.mindtree.FlightApp.entity.InFlightShop;
import com.mindtree.FlightApp.exception.ControllerException;
import com.mindtree.FlightApp.exception.ServiceException;
import com.mindtree.FlightApp.serviceinter.InFlightShopService;


@CrossOrigin(origins="*" , allowedHeaders = "*")
@RestController
@RequestMapping("/Flight-App/Admin/Shop")
public class InFlightShopController {
	@Autowired
	InFlightShopService shopservice;
	
	@PostMapping(value="/{flightID}")
	public String addShopItems(@RequestBody InFlightShop items, @PathVariable String flightID) throws ControllerException
	{
		try {
			return shopservice.addShopItems(items,flightID);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@PutMapping(value="/{flightID}")
	public String updateShopItems(@RequestBody InFlightShop items, @PathVariable String flightID) throws ControllerException
	{
		try {
			return shopservice.updateShopItems(items,flightID);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@DeleteMapping
	public String deleteShopItems(@RequestParam(value="itemid") int itemid) throws ControllerException
	{
		try {
			return shopservice.deletShopItems(itemid);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@GetMapping(value="/{flightID}")
	public List<InFlightShop> displayShopItems(@PathVariable String flightID) throws ControllerException
	{
		try {
			return shopservice.displayShopItems(flightID);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
}
