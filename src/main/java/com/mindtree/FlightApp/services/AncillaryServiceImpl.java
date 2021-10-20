package com.mindtree.FlightApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.FlightApp.entity.AncillaryServices;
import com.mindtree.FlightApp.exception.ServiceException;
import com.mindtree.FlightApp.repository.AncillaryServicesRepo;
import com.mindtree.FlightApp.repository.PassengerFlightDetailsRepo;
import com.mindtree.FlightApp.serviceinter.AncillaryService;

@Service
public class AncillaryServiceImpl implements AncillaryService{
	@Autowired
	AncillaryServicesRepo servicesrepo;
	@Autowired
	PassengerFlightDetailsRepo flightrepo;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String addServices(AncillaryServices services, String passengerID) throws ServiceException {
		services.setpassengerflightdetails(flightrepo.findBypassengerID(passengerID));
		servicesrepo.save(services);
		return "Services added";
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String updateServices(AncillaryServices services, String passengerID) throws ServiceException {
		services.setpassengerflightdetails(flightrepo.findBypassengerID(passengerID));
		servicesrepo.save(services);
		return "Services Updated";
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public AncillaryServices displayServices(String passengerID) throws ServiceException {
		return servicesrepo.findBypassengerID(passengerID);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String deleteServices(String passengerID) throws ServiceException {
		servicesrepo.delete(servicesrepo.findBypassengerID(passengerID));
		return "Services Deleted";
	}
	

}
