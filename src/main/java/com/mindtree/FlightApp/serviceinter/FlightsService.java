package com.mindtree.FlightApp.serviceinter;

import java.util.Date;
import java.util.List;

import com.mindtree.FlightApp.entity.Flights;
import com.mindtree.FlightApp.exception.ServiceException;

public interface FlightsService {

	String addFlights(Flights flight) throws ServiceException;

	List<Flights> getFlights(Date time, String company) throws ServiceException;

	List<Flights> getFlightsbyCompany(String company) throws ServiceException;

	List<Flights> getAllFlights()throws ServiceException;

}
