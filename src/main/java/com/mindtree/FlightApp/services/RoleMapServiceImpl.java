package com.mindtree.FlightApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.FlightApp.entity.RoleMap;
import com.mindtree.FlightApp.repository.RoleMapRepo;
import com.mindtree.FlightApp.serviceinter.RoleMapService;

@Service
public class RoleMapServiceImpl implements RoleMapService{
	
	@Autowired
	RoleMapRepo rolemaprepo;
	
	@Override
	public RoleMap getRoles(String user) {
		
		return rolemaprepo.findByuserID(user);
	}

	
}
