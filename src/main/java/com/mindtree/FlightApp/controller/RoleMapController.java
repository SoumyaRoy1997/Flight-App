package com.mindtree.FlightApp.controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.FlightApp.entity.RoleMap;
import com.mindtree.FlightApp.repository.RoleMapRepo;
import com.mindtree.FlightApp.serviceinter.RoleMapService;

@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/Flight-App/RoleMap")
public class RoleMapController {
	
	@Autowired
	RoleMapService rolemapservice;
	
	@GetMapping
	public RoleMap getRoles(@RequestParam String user)
	{
		return rolemapservice.getRoles(user);
	}
}
