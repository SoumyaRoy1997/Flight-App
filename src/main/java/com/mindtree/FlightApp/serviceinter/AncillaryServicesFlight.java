package com.mindtree.FlightApp.serviceinter;

import java.util.List;

import com.mindtree.FlightApp.entity.AncillaryServiceFlight;
import com.mindtree.FlightApp.exception.ServiceException;

public interface AncillaryServicesFlight {

	List<AncillaryServiceFlight> displayServices(String flightID)throws ServiceException;

	String deleteServices(int serviceid)throws ServiceException;

	String updateServices(AncillaryServiceFlight services, String flightID)throws ServiceException;

	String addServices(AncillaryServiceFlight services, String flightID)throws ServiceException;

}
