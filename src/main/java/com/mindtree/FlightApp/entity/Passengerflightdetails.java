package com.mindtree.FlightApp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Passengerflightdetails {

	@Id
	@Column(name="passenger_id")
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",
	  strategy = "uuid")
	private String passengerID;
	
	@Column(name="wheelchair")
	private boolean wheelchair;
	
	@Column(name="infants")
	private boolean infants;
	
	@Column(name="meals")
	private boolean meals;
	
	@Column(name="ancillary_services")
	private boolean ancillaryServices;
	
	@Column(name="seatPref")
	private String seatPref;
	
	@Column(name="seat_number")
	private String seat_number;
	
	@Column(name="checkin")
	private boolean checkin;
	
	@JsonIgnoreProperties("passengerflightdetails")
	@ManyToOne(cascade=CascadeType.REFRESH , fetch=FetchType.EAGER)
	private Flights flight;
	
	@JsonIgnore
	@OneToOne(cascade=CascadeType.PERSIST,mappedBy="passengerflightdetails" , fetch=FetchType.EAGER)
	private Passengerbookingdetails passengerbookingdetails;
	
	@JsonIgnore
	@OneToOne(cascade=CascadeType.PERSIST, mappedBy="passengerflightdetails" , fetch=FetchType.EAGER)
	private AncillaryServices services;
	
	@JsonIgnoreProperties("passengerflightdetails")
	@ManyToMany(cascade=CascadeType.ALL)
	private List<InFlightShop> items;
	
	@JsonIgnoreProperties("passengerflightdetails")
	@ManyToMany(cascade=CascadeType.ALL)
	private List<SpecialMeals> specialmeals;
	
	public Passengerflightdetails() {
		super();
	}
	


	public Passengerflightdetails(String passengerID, boolean wheelchair, boolean infants, boolean meals,
			boolean ancillaryServices, String seatPref, String seat_number, boolean checkin, Flights flight,
			Passengerbookingdetails passengerbookingdetails, AncillaryServices services, List<InFlightShop> items,
			List<SpecialMeals> specialmeals) {
		super();
		this.passengerID = passengerID;
		this.wheelchair = wheelchair;
		this.infants = infants;
		this.meals = meals;
		this.ancillaryServices = ancillaryServices;
		this.seatPref = seatPref;
		this.seat_number = seat_number;
		this.checkin = checkin;
		this.flight = flight;
		this.passengerbookingdetails = passengerbookingdetails;
		this.services = services;
		this.items = items;
		this.specialmeals = specialmeals;
	}



	public List<InFlightShop> getItems() {
		return items;
	}

	public void setItems(List<InFlightShop> items) {
		this.items = items;
	}

	public String getPassengerID() {
		return passengerID;
	}
	public void setPassengerID(String passengerID) {
		this.passengerID = passengerID;
	}
	public boolean isWheelchair() {
		return wheelchair;
	}
	public void setWheelchair(boolean wheelchair) {
		this.wheelchair = wheelchair;
	}
	public boolean isInfants() {
		return infants;
	}
	public void setInfants(boolean infants) {
		this.infants = infants;
	}
	public boolean isMeals() {
		return meals;
	}
	public void setMeals(boolean meals) {
		this.meals = meals;
	}
	public boolean isAncillaryServices() {
		return ancillaryServices;
	}
	public void setAncillaryServices(boolean ancillaryServices) {
		this.ancillaryServices = ancillaryServices;
	}
	public String getSeatPref() {
		return seatPref;
	}
	public void setSeatPref(String seatPref) {
		this.seatPref = seatPref;
	}
	public String getSeat_number() {
		return seat_number;
	}
	public void setSeat_number(String seat_number) {
		this.seat_number = seat_number;
	}
	public Flights getFlight() {
		return flight;
	}
	public void setFlight(Flights flight) {
		this.flight = flight;
	}
	public Passengerbookingdetails getPassengerbookingdetails() {
		return passengerbookingdetails;
	}
	public void setPassengerbookingdetails(Passengerbookingdetails passengerbookingdetails) {
		this.passengerbookingdetails = passengerbookingdetails;
	}
	
	public boolean isCheckin() {
		return checkin;
	}

	public void setCheckin(boolean checkin) {
		this.checkin = checkin;
	}
	public AncillaryServices getServices() {
		return services;
	}

	public void setServices(AncillaryServices services) {
		this.services = services;
	}
	
	public List<SpecialMeals> getSpecialmeals() {
		return specialmeals;
	}



	public void setSpecialmeals(List<SpecialMeals> specialmeals) {
		this.specialmeals = specialmeals;
	}



	@Override
	public String toString() {
		return "Passengerflightdetails [passengerID=" + passengerID + ", wheelchair=" + wheelchair + ", infants="
				+ infants + ", meals=" + meals + ", ancillaryServices=" + ancillaryServices + ", seatPref=" + seatPref
				+ ", seat_number=" + seat_number + ", checkin=" + checkin + ", flight=" + flight
				+ ", passengerbookingdetails=" + passengerbookingdetails + ", services=" + services + ", items=" + items
				+ ", specialmeals=" + specialmeals + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ancillaryServices ? 1231 : 1237);
		result = prime * result + (checkin ? 1231 : 1237);
		result = prime * result + ((flight == null) ? 0 : flight.hashCode());
		result = prime * result + (infants ? 1231 : 1237);
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + (meals ? 1231 : 1237);
		result = prime * result + ((passengerID == null) ? 0 : passengerID.hashCode());
		result = prime * result + ((passengerbookingdetails == null) ? 0 : passengerbookingdetails.hashCode());
		result = prime * result + ((seatPref == null) ? 0 : seatPref.hashCode());
		result = prime * result + ((seat_number == null) ? 0 : seat_number.hashCode());
		result = prime * result + ((services == null) ? 0 : services.hashCode());
		result = prime * result + ((specialmeals == null) ? 0 : specialmeals.hashCode());
		result = prime * result + (wheelchair ? 1231 : 1237);
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
		Passengerflightdetails other = (Passengerflightdetails) obj;
		if (ancillaryServices != other.ancillaryServices)
			return false;
		if (checkin != other.checkin)
			return false;
		if (flight == null) {
			if (other.flight != null)
				return false;
		} else if (!flight.equals(other.flight))
			return false;
		if (infants != other.infants)
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (meals != other.meals)
			return false;
		if (passengerID == null) {
			if (other.passengerID != null)
				return false;
		} else if (!passengerID.equals(other.passengerID))
			return false;
		if (passengerbookingdetails == null) {
			if (other.passengerbookingdetails != null)
				return false;
		} else if (!passengerbookingdetails.equals(other.passengerbookingdetails))
			return false;
		if (seatPref == null) {
			if (other.seatPref != null)
				return false;
		} else if (!seatPref.equals(other.seatPref))
			return false;
		if (seat_number == null) {
			if (other.seat_number != null)
				return false;
		} else if (!seat_number.equals(other.seat_number))
			return false;
		if (services == null) {
			if (other.services != null)
				return false;
		} else if (!services.equals(other.services))
			return false;
		if (specialmeals == null) {
			if (other.specialmeals != null)
				return false;
		} else if (!specialmeals.equals(other.specialmeals))
			return false;
		if (wheelchair != other.wheelchair)
			return false;
		return true;
	}

	
}
