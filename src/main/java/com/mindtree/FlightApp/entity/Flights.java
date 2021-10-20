package com.mindtree.FlightApp.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
public class Flights {

	@Id
	@Column(name="flight_id")
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",
	  strategy = "uuid")
	
	private String FlightId;
	
	@Column(name="company")
	private String company;
	
	
	@Column(name="departure")
	private Date Departure;
	
	
	@Column(name="arrival")
	private Date Arrival;
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="pickup")
	private String pickup;
	
	@Column(name="passengers")
	private int passengers;
	
	@Column(name="limitpassengers")
	private int limitpassengers;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.PERSIST ,fetch=FetchType.EAGER)
	private Admin admin;
	
	@JsonIgnoreProperties("flight")
	@OneToMany(cascade=CascadeType.REFRESH,mappedBy="flight" )
	private List<Passengerflightdetails> passengerflightdetails;
	
	@JsonIgnoreProperties("flight")
	@OneToMany(cascade=CascadeType.PERSIST, mappedBy="flight" )
	private List<InFlightShop> item;
	
	@JsonIgnoreProperties("flight")
	@OneToMany(cascade=CascadeType.PERSIST, mappedBy="flight" )
	private List<SpecialMeals> meals;
	
	@JsonIgnoreProperties("flight")
	@OneToMany(cascade=CascadeType.PERSIST, mappedBy="flight" )
	private List<AncillaryServiceFlight> ancillaryservice;
	
	public List<InFlightShop> getItem() {
		return item;
	}
	public void setItem(List<InFlightShop> item) {
		this.item = item;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getFlightId() {
		return FlightId;
	}
	public void setFlightId(String flightId) {
		FlightId = flightId;
	}
	public Date getDeparture() {
		return Departure;
	}
	public void setDeparture(Date departure) {
		Departure = departure;
	}
	public Date getArrival() {
		return Arrival;
	}
	public void setArrival(Date arrival) {
		Arrival = arrival;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getPickup() {
		return pickup;
	}
	public void setPickup(String pickup) {
		this.pickup = pickup;
	}
	public int getPassengers() {
		return passengers;
	}
	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public List<Passengerflightdetails> getPassengerflightdetails() {
		return passengerflightdetails;
	}
	public void setPassengerflightdetails(List<Passengerflightdetails> passengerflightdetails) {
		this.passengerflightdetails = passengerflightdetails;
	}
	
	public int getlimitpassengers() {
		return limitpassengers;
	}
	public void setlimitpassengers(int limitpassengers) {
		this.limitpassengers = limitpassengers;
	}
	public List<SpecialMeals> getMeals() {
		return meals;
	}
	public void setMeals(List<SpecialMeals> meals) {
		this.meals = meals;
	}
	public List<AncillaryServiceFlight> getAncillaryservice() {
		return ancillaryservice;
	}
	public void setAncillaryservice(List<AncillaryServiceFlight> ancillaryservice) {
		this.ancillaryservice = ancillaryservice;
	}
	public Flights() {
		super();
	}
	public Flights(String flightId, String company, Date departure, Date arrival, String destination, String pickup,
			int passengers, int limitpassengers, Admin admin, List<Passengerflightdetails> passengerflightdetails,
			List<InFlightShop> item, List<SpecialMeals> meals, List<AncillaryServiceFlight> ancillaryservice) {
		super();
		FlightId = flightId;
		this.company = company;
		Departure = departure;
		Arrival = arrival;
		this.destination = destination;
		this.pickup = pickup;
		this.passengers = passengers;
		this.limitpassengers = limitpassengers;
		this.admin = admin;
		this.passengerflightdetails = passengerflightdetails;
		this.item = item;
		this.meals = meals;
		this.ancillaryservice = ancillaryservice;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Arrival == null) ? 0 : Arrival.hashCode());
		result = prime * result + ((Departure == null) ? 0 : Departure.hashCode());
		result = prime * result + ((FlightId == null) ? 0 : FlightId.hashCode());
		result = prime * result + ((admin == null) ? 0 : admin.hashCode());
		result = prime * result + ((ancillaryservice == null) ? 0 : ancillaryservice.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + limitpassengers;
		result = prime * result + ((meals == null) ? 0 : meals.hashCode());
		result = prime * result + ((passengerflightdetails == null) ? 0 : passengerflightdetails.hashCode());
		result = prime * result + passengers;
		result = prime * result + ((pickup == null) ? 0 : pickup.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flights other = (Flights) obj;
		if (Arrival == null) {
			if (other.Arrival != null)
				return false;
		} else if (!Arrival.equals(other.Arrival))
			return false;
		if (Departure == null) {
			if (other.Departure != null)
				return false;
		} else if (!Departure.equals(other.Departure))
			return false;
		if (FlightId == null) {
			if (other.FlightId != null)
				return false;
		} else if (!FlightId.equals(other.FlightId))
			return false;
		if (admin == null) {
			if (other.admin != null)
				return false;
		} else if (!admin.equals(other.admin))
			return false;
		if (ancillaryservice == null) {
			if (other.ancillaryservice != null)
				return false;
		} else if (!ancillaryservice.equals(other.ancillaryservice))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (limitpassengers != other.limitpassengers)
			return false;
		if (meals == null) {
			if (other.meals != null)
				return false;
		} else if (!meals.equals(other.meals))
			return false;
		if (passengerflightdetails == null) {
			if (other.passengerflightdetails != null)
				return false;
		} else if (!passengerflightdetails.equals(other.passengerflightdetails))
			return false;
		if (passengers != other.passengers)
			return false;
		if (pickup == null) {
			if (other.pickup != null)
				return false;
		} else if (!pickup.equals(other.pickup))
			return false;
		return true;
	}
	
}
