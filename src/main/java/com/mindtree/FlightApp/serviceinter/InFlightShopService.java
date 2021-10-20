package com.mindtree.FlightApp.serviceinter;

import java.util.List;

import com.mindtree.FlightApp.entity.InFlightShop;
import com.mindtree.FlightApp.exception.ServiceException;

public interface InFlightShopService {

	String addShopItems(InFlightShop items, String flightID) throws ServiceException;

	String deletShopItems(int itemid) throws ServiceException;

	String updateShopItems(InFlightShop items, String flightID) throws ServiceException;

	List<InFlightShop> displayShopItems(String flightID) throws ServiceException;

}
