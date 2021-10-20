package com.mindtree.FlightApp.serviceinter;

import java.util.List;
import java.util.Optional;

import com.mindtree.FlightApp.entity.Admin;
import com.mindtree.FlightApp.exception.ServiceException;

public interface AdminService {

	String addAdmin(Admin admin) throws ServiceException;

	String updateAdmin(Admin admin) throws ServiceException;

	Optional<Admin> getAdmins(String adminId) throws ServiceException;
	
}
