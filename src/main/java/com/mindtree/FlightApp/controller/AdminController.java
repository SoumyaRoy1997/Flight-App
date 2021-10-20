package com.mindtree.FlightApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.FlightApp.entity.Admin;
import com.mindtree.FlightApp.exception.ControllerException;
import com.mindtree.FlightApp.exception.ServiceException;
import com.mindtree.FlightApp.repository.AdminRepo;
import com.mindtree.FlightApp.serviceinter.AdminService;

@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/Flight-App/Admin")
public class AdminController {
	@Autowired
	AdminService adminservice;
	
	
	@PostMapping
	public String addAdmin(@RequestBody Admin admin) throws ControllerException
	{
		
		try {
			return adminservice.addAdmin(admin);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	
	@PutMapping
	public String updateAdmin(@RequestBody Admin admin) throws ControllerException
	{
		try {
			return adminservice.updateAdmin(admin);
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
	@GetMapping
	public Optional<Admin> getAdmins(@RequestParam(value="Id") String adminId)throws ControllerException
	{
		try
		{
			return adminservice.getAdmins(adminId);
		}
		catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
	}
}
