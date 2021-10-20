package com.mindtree.FlightApp.serviceinter;

import java.util.List;

import com.mindtree.FlightApp.entity.Passengerbookingdetails;
import com.mindtree.FlightApp.exception.ServiceException;

public interface PassengerBookingDetailsService {

	String addPassenger(Passengerbookingdetails passenger) throws ServiceException;

	String updatePassenger(Passengerbookingdetails passenger) throws ServiceException;

	List<Passengerbookingdetails> getPassenger(String flightID) throws ServiceException;

}
