package com.mindtree.FlightApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.FlightApp.entity.Admin;
import com.mindtree.FlightApp.exception.ServiceException;
import com.mindtree.FlightApp.repository.AdminRepo;
import com.mindtree.FlightApp.serviceinter.AdminService;


@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	AdminRepo adminrepo;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String addAdmin(Admin admin) throws ServiceException {
		
		return adminrepo.save(admin).getAdminID();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String updateAdmin(Admin admin) throws ServiceException {
		
		adminrepo.save(admin);
		return "Admin Details Updated";
	}

	@Override
	public Optional<Admin> getAdmins(String adminId) throws ServiceException{
		
		return adminrepo.findById(adminId);
	}
	

}
