package com.mindtree.FlightApp.services;

import java.util.List;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.FlightApp.entity.AncillaryServices;
import com.mindtree.FlightApp.entity.Flights;
import com.mindtree.FlightApp.entity.Passengerbookingdetails;
import com.mindtree.FlightApp.exception.ServiceException;
import com.mindtree.FlightApp.repository.AncillaryServicesRepo;
import com.mindtree.FlightApp.repository.FlightsRepo;
import com.mindtree.FlightApp.repository.PassengerBookingDetailsRepo;
import com.mindtree.FlightApp.serviceinter.PassengerBookingDetailsService;

@Service
public class PassengerBookingDetailsServiceImpl implements PassengerBookingDetailsService{
	@Autowired
	PassengerBookingDetailsRepo bookingrepo;
	@Autowired
	AncillaryServicesRepo servicesrepo;
	@Autowired
	FlightsRepo flightrepo;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String addPassenger(Passengerbookingdetails passenger) throws ServiceException {
		String pnr=UUID.randomUUID().toString();
		passenger.setPnr(pnr);
		Flights flightdetail=flightrepo.findByFlightId(passenger.getPassengerflightdetails().getFlight().getFlightId());
		if(flightdetail.getPassengers()<flightdetail.getlimitpassengers())
		{
			if(passenger.getPassengerflightdetails().isAncillaryServices()==true)
			{
			AncillaryServices services=new AncillaryServices();
			services.setpassengerflightdetails(passenger.getPassengerflightdetails());
			services.setHeadpillow(true);
			services.setMagazine(true);
			services.setPets(true);
			servicesrepo.save(services);
			}
			flightdetail.setPassengers(flightdetail.getPassengers()+1);
			flightrepo.save(flightdetail);
		}
		else
		{
			throw new ServiceException("Flight is Full");
		}
		return "Your Flight is successfully booked , please note your PNR: "+bookingrepo.save(passenger).getPnr();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String updatePassenger(Passengerbookingdetails passenger) throws ServiceException {
		try
		{
		if(!passenger.getPassengerflightdetails().getItems().isEmpty())
		{
			for(int i=0;i<passenger.getPassengerflightdetails().getItems().size();i++)
			{
				passenger.getPassengerflightdetails().getItems().get(i).setFlight(passenger.getPassengerflightdetails().getFlight());
			}
		}
		bookingrepo.save(passenger);
		return "Passenger Details Updated";
		}
		catch(Exception ex)
		{
			throw new ServiceException("Error In Updating");
		}
	}

	@Override
	public List<Passengerbookingdetails> getPassenger(String flightID) throws ServiceException {
		
		return bookingrepo.findByFlightId(flightID);
	}
	
	

}
