package com.mindtree.FlightApp.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.FlightApp.entity.Admin;
import com.mindtree.FlightApp.entity.Flights;
import com.mindtree.FlightApp.entity.RoleMap;
import com.mindtree.FlightApp.exception.ServiceException;
import com.mindtree.FlightApp.repository.AdminRepo;
import com.mindtree.FlightApp.repository.FlightsRepo;
import com.mindtree.FlightApp.repository.RoleMapRepo;
import com.mindtree.FlightApp.serviceinter.FlightsService;

@Service
public class FlightsServiceImpl implements FlightsService{
	@Autowired
	FlightsRepo flightsrepo;
	@Autowired
	AdminRepo adminrepo;
	@Autowired
	RoleMapRepo rolemaprepo;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String addFlights(Flights flight) throws ServiceException {
		Admin admin=new Admin();
		if(flight.getAdmin()==null)
		{
			admin=adminrepo.findBycompanyName(flight.getCompany());
			flight.setAdmin(admin);
		}
		else
		{
			RoleMap role=new RoleMap();
			role.setRole(2);
			role.setUserID(flight.getAdmin().getAdminID());
			rolemaprepo.save(role);
		}
		return flightsrepo.save(flight).getFlightId();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Flights> getFlights(Date time,String company) throws ServiceException {
		
		return flightsrepo.findByDeparture(time,company);
	}

	@Override
	public List<Flights> getFlightsbyCompany(String company) throws ServiceException {
		
		return flightsrepo.findByCompany(company);
	}

	@Override
	public List<Flights> getAllFlights() throws ServiceException {
		
		return flightsrepo.findAll();
	}

}
