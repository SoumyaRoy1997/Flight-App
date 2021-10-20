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

@Entity
public class SpecialMeals {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mealID")
	private int mealID;
	
	@Column(name="mealName")
	private String mealName;
	
	@Column(name="price")
	private double price;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.PERSIST )
	private Flights flight;
	
	@JsonIgnore
	@ManyToMany(cascade=CascadeType.PERSIST , fetch=FetchType.EAGER, mappedBy="specialmeals")
	private List<Passengerflightdetails> passenger;

	public SpecialMeals(int mealID, String mealName, double price, Flights flight,
			List<Passengerflightdetails> passenger) {
		super();
		this.mealID = mealID;
		this.mealName = mealName;
		this.price = price;
		this.flight = flight;
		this.passenger = passenger;
	}

	public SpecialMeals() {
		super();
	}

	@Override
	public String toString() {
		return "SpecialMeals [mealID=" + mealID + ", mealName=" + mealName + ", price=" + price + ", flight=" + flight
				+ ", passenger=" + passenger + "]";
	}

	public int getMealID() {
		return mealID;
	}

	public void setMealID(int mealID) {
		this.mealID = mealID;
	}

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Flights getFlight() {
		return flight;
	}

	public void setFlight(Flights flight) {
		this.flight = flight;
	}

	public List<Passengerflightdetails> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<Passengerflightdetails> passenger) {
		this.passenger = passenger;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flight == null) ? 0 : flight.hashCode());
		result = prime * result + mealID;
		result = prime * result + ((mealName == null) ? 0 : mealName.hashCode());
		result = prime * result + ((passenger == null) ? 0 : passenger.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		SpecialMeals other = (SpecialMeals) obj;
		if (flight == null) {
			if (other.flight != null)
				return false;
		} else if (!flight.equals(other.flight))
			return false;
		if (mealID != other.mealID)
			return false;
		if (mealName == null) {
			if (other.mealName != null)
				return false;
		} else if (!mealName.equals(other.mealName))
			return false;
		if (passenger == null) {
			if (other.passenger != null)
				return false;
		} else if (!passenger.equals(other.passenger))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}
	
	
}
