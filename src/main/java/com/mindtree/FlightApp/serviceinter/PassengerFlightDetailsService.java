package com.mindtree.FlightApp.serviceinter;

import java.util.Date;
import java.util.List;

import com.mindtree.FlightApp.entity.Passengerflightdetails;
import com.mindtree.FlightApp.exception.ServiceException;


public interface PassengerFlightDetailsService {

	String addPassenger(Passengerflightdetails passenger, String flightID)  throws ServiceException;

	String updatePassenger(Passengerflightdetails passenger, String flightID) throws ServiceException;

	List<Passengerflightdetails> displayPassenger(String flightID) throws ServiceException;

	List<Passengerflightdetails> displayPassengerfiltercheckin(String flightID, boolean filterby) throws ServiceException;

	List<Passengerflightdetails> displayPassengerfilterwheelchair(String flightID, boolean filterby) throws ServiceException;

	List<Passengerflightdetails> displayPassengerfilterInfant(String flightID, boolean filterby) throws ServiceException;

	List<Passengerflightdetails> displayPassengerfilterMeals(String flightID, boolean filterby) throws ServiceException;

	List<Passengerflightdetails> displayPassengerfilterAncillary(String flightID, boolean filterby) throws ServiceException;

	List<Passengerflightdetails> displayPassengerfilterPassport(String flightID, boolean filterby) throws ServiceException;

	List<Passengerflightdetails> displayPassengerfilterAddress(String flightID, String filterby) throws ServiceException;

	List<Passengerflightdetails> displayPassengerfilterDOB(String flightID, Date filterby) throws ServiceException;

}
