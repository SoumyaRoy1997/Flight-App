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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
public class InFlightShop {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="itemID")
	private int itemID;

	@Column(name="itemName")
	private String itemName;

	@Column(name="itemType")
	private String itemType;


	@Column(name="Price")
	private double Price;


	@Column(name="availableUnits")
	private int availableUnits;

	@JsonIgnore
	@ManyToOne(cascade=CascadeType.PERSIST , fetch=FetchType.EAGER)
	private Flights flight;

	@JsonIgnore
	@ManyToMany(cascade=CascadeType.PERSIST , fetch=FetchType.EAGER, mappedBy="items")
	private List<Passengerflightdetails> passenger;
	
	
	public List<Passengerflightdetails> getPassenger() {
		return passenger;
	}


	public void setPassenger(List<Passengerflightdetails> passenger) {
		this.passenger = passenger;
	}


	public int getItemID() {
		return itemID;
	}


	public void setItemID(int itemID) {
		this.itemID = itemID;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getItemType() {
		return itemType;
	}


	public void setItemType(String itemType) {
		this.itemType = itemType;
	}


	public double getPrice() {
		return Price;
	}


	public void setPrice(double price) {
		Price = price;
	}


	public int getAvailableUnits() {
		return availableUnits;
	}


	public void setAvailableUnits(int availableUnits) {
		this.availableUnits = availableUnits;
	}


	public Flights getFlight() {
		return flight;
	}


	public void setFlight(Flights flight) {
		this.flight = flight;
	}

	

	public InFlightShop(int itemID, String itemName, String itemType, double price, int availableUnits, Flights flight,
			List<Passengerflightdetails> passenger) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemType = itemType;
		Price = price;
		this.availableUnits = availableUnits;
		this.flight = flight;
		this.passenger = passenger;
	}


	public InFlightShop() {
		super();
	}


	@Override
	public String toString() {
		return "InFlightShop [itemID=" + itemID + ", itemName=" + itemName + ", itemType=" + itemType + ", Price="
				+ Price + ", availableUnits=" + availableUnits + ", flight=" + flight + ", passenger=" + passenger
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(Price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + availableUnits;
		result = prime * result + ((flight == null) ? 0 : flight.hashCode());
		result = prime * result + itemID;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((itemType == null) ? 0 : itemType.hashCode());
		result = prime * result + ((passenger == null) ? 0 : passenger.hashCode());
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
		InFlightShop other = (InFlightShop) obj;
		if (Double.doubleToLongBits(Price) != Double.doubleToLongBits(other.Price))
			return false;
		if (availableUnits != other.availableUnits)
			return false;
		if (flight == null) {
			if (other.flight != null)
				return false;
		} else if (!flight.equals(other.flight))
			return false;
		if (itemID != other.itemID)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (itemType == null) {
			if (other.itemType != null)
				return false;
		} else if (!itemType.equals(other.itemType))
			return false;
		if (passenger == null) {
			if (other.passenger != null)
				return false;
		} else if (!passenger.equals(other.passenger))
			return false;
		return true;
	}
}
