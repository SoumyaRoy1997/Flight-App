package com.mindtree.FlightApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.FlightApp.entity.InFlightShop;
import com.mindtree.FlightApp.exception.ServiceException;
import com.mindtree.FlightApp.repository.FlightsRepo;
import com.mindtree.FlightApp.repository.InFlightShopRepo;
import com.mindtree.FlightApp.serviceinter.InFlightShopService;

@Service
public class InFlightShopServiceImpl implements InFlightShopService{
	@Autowired
	InFlightShopRepo shoprepo;
	@Autowired
	FlightsRepo flightrepo;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String addShopItems(InFlightShop items, String flightID) throws ServiceException {
		items.setFlight(flightrepo.findByFlightId(flightID));
		shoprepo.save(items);
		return "Items Added";
	}

	@Override
	@Transactional
	public String deletShopItems(int itemid) throws ServiceException {
		shoprepo.deleteById(itemid);
		return "Items Deleted";
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String updateShopItems(InFlightShop items, String flightID) throws ServiceException {
		items.setFlight(shoprepo.findById(items.getItemID()).get().getFlight());
		shoprepo.save(items);
		return "Items Updated";
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<InFlightShop> displayShopItems(String flightID) throws ServiceException {
		
		return shoprepo.findByFlightId(flightID);
	}

}
