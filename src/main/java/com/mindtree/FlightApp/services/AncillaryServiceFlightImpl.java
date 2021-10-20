package com.mindtree.FlightApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.FlightApp.entity.AncillaryServiceFlight;
import com.mindtree.FlightApp.exception.ServiceException;
import com.mindtree.FlightApp.repository.AncillaryServicesFlightRepo;
import com.mindtree.FlightApp.repository.FlightsRepo;
import com.mindtree.FlightApp.serviceinter.AncillaryServicesFlight;

@Service
public class AncillaryServiceFlightImpl implements AncillaryServicesFlight{
	@Autowired
	AncillaryServicesFlightRepo servicesrepo;
	@Autowired
	FlightsRepo flightrepo;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<AncillaryServiceFlight> displayServices(String flightID) throws ServiceException {
		
		return servicesrepo.findByFlightId(flightID);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String deleteServices(int serviceid) throws ServiceException {
		servicesrepo.deleteById(serviceid);
		return "Service Deleted";
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String updateServices(AncillaryServiceFlight services, String flightID) throws ServiceException {
		services.setFlight(servicesrepo.findById(services.getServiceID()).get().getFlight());
		servicesrepo.save(services);
		return "Services Updated";
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String addServices(AncillaryServiceFlight services, String flightID) throws ServiceException {
		services.setFlight(flightrepo.findByFlightId(flightID));
		servicesrepo.save(services);
		return "Services Added";
	}
}
