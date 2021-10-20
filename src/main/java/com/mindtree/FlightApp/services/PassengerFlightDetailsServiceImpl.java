package com.mindtree.FlightApp.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.FlightApp.entity.AncillaryServices;
import com.mindtree.FlightApp.entity.Passengerbookingdetails;
import com.mindtree.FlightApp.entity.Passengerflightdetails;
import com.mindtree.FlightApp.exception.ServiceException;
import com.mindtree.FlightApp.repository.FlightsRepo;
import com.mindtree.FlightApp.repository.PassengerFlightDetailsRepo;
import com.mindtree.FlightApp.serviceinter.PassengerFlightDetailsService;

@Service
public class PassengerFlightDetailsServiceImpl implements PassengerFlightDetailsService{
	
	@Autowired
	PassengerFlightDetailsRepo passengerrepo;
	@Autowired
	FlightsRepo flightrepo;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String addPassenger(Passengerflightdetails passenger, String flightID) throws ServiceException {
		passenger.setFlight(flightrepo.findByFlightId(flightID));
		passengerrepo.save(passenger);
		return "Passenger Added";
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String updatePassenger(Passengerflightdetails passenger, String flightID) throws ServiceException {
		passenger.setFlight(flightrepo.findByFlightId(flightID));
		passenger.setPassengerbookingdetails(passengerrepo.findBypassengerID(passenger.getPassengerID()).getPassengerbookingdetails());
//		AncillaryServices services=new AncillaryServices();
//		services.setpassengerflightdetails(passenger);
//		passenger.setServices(services);
//		Passengerbookingdetails bookingdetails=new Passengerbookingdetails();
//		bookingdetails.setPassengerflightdetails(passenger);
//		passenger.setPassengerbookingdetails(bookingdetails);
		passenger.setItems(passengerrepo.findBypassengerID(passenger.getPassengerID()).getItems());
		passengerrepo.save(passenger);
		return "Passenger Updated";
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Passengerflightdetails> displayPassenger(String flightID) throws ServiceException {
		return passengerrepo.findByFlightId(flightID);
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Passengerflightdetails> displayPassengerfiltercheckin(String flightID, boolean filterby) throws ServiceException {
		
		return passengerrepo.findBycheckin(filterby, flightID);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Passengerflightdetails> displayPassengerfilterwheelchair(String flightID, boolean filterby) throws ServiceException {
		
		return passengerrepo.findByWheelchair(filterby, flightID);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Passengerflightdetails> displayPassengerfilterInfant(String flightID, boolean filterby) throws ServiceException {
		
		return passengerrepo.findByInfants(filterby, flightID);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Passengerflightdetails> displayPassengerfilterMeals(String flightID, boolean filterby) throws ServiceException {
		
		return passengerrepo.findBymeals(filterby, flightID);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Passengerflightdetails> displayPassengerfilterAncillary(String flightID, boolean filterby) throws ServiceException {
		
		return passengerrepo.findByancillaryServices(filterby, flightID);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Passengerflightdetails> displayPassengerfilterPassport(String flightID, boolean filterby) throws ServiceException {
		
		return passengerrepo.findBypassport(filterby, flightID);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Passengerflightdetails> displayPassengerfilterAddress(String flightID, String filterby) throws ServiceException {
		
		return passengerrepo.findByAddress(filterby, flightID);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Passengerflightdetails> displayPassengerfilterDOB(String flightID, Date filterby) throws ServiceException {
		
		return passengerrepo.findByDOB(filterby, flightID);
	}
	
}
