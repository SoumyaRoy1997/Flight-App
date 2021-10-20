package com.mindtree.FlightApp.serviceinter;

import com.mindtree.FlightApp.entity.AncillaryServices;
import com.mindtree.FlightApp.exception.ServiceException;

public interface AncillaryService {

	String addServices(AncillaryServices services, String passengerID) throws ServiceException;

	String updateServices(AncillaryServices services, String passengerID) throws ServiceException;

	AncillaryServices displayServices(String passengerID) throws ServiceException;

	String deleteServices(String passengerID) throws ServiceException;

}
