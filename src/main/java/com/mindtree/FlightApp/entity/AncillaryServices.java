package com.mindtree.FlightApp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
public class AncillaryServices {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serviceID;
	
	@Column(name="magazine")
	private boolean magazine;
	
	@Column(name="headpillow")
	private boolean headpillow;
	
	@Column(name="pets")
	private boolean pets;
	
	@JsonIgnoreProperties("services")
	@OneToOne(cascade=CascadeType.PERSIST , fetch=FetchType.EAGER )
	private Passengerflightdetails passengerflightdetails; 
	public AncillaryServices() {
		super();
	}

	
	public AncillaryServices(int serviceID, boolean magazine, boolean headpillow, boolean pets,
			Passengerflightdetails passengerflightdetails) {
		super();
		this.serviceID = serviceID;
		this.magazine = magazine;
		this.headpillow = headpillow;
		this.pets = pets;
		this.passengerflightdetails = passengerflightdetails;
	}


	public Passengerflightdetails getpassengerflightdetails() {
		return passengerflightdetails;
	}


	public void setpassengerflightdetails(Passengerflightdetails passengerflightdetails) {
		this.passengerflightdetails = passengerflightdetails;
	}


	public int getServiceID() {
		return serviceID;
	}

	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}

	public boolean isMagazine() {
		return magazine;
	}

	public void setMagazine(boolean magazine) {
		this.magazine = magazine;
	}

	public boolean isHeadpillow() {
		return headpillow;
	}

	public void setHeadpillow(boolean headpillow) {
		this.headpillow = headpillow;
	}

	public boolean isPets() {
		return pets;
	}

	public void setPets(boolean pets) {
		this.pets = pets;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (headpillow ? 1231 : 1237);
		result = prime * result + (magazine ? 1231 : 1237);
		result = prime * result + ((passengerflightdetails == null) ? 0 : passengerflightdetails.hashCode());
		result = prime * result + (pets ? 1231 : 1237);
		result = prime * result + serviceID;
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
		AncillaryServices other = (AncillaryServices) obj;
		if (headpillow != other.headpillow)
			return false;
		if (magazine != other.magazine)
			return false;
		if (passengerflightdetails == null) {
			if (other.passengerflightdetails != null)
				return false;
		} else if (!passengerflightdetails.equals(other.passengerflightdetails))
			return false;
		if (pets != other.pets)
			return false;
		if (serviceID != other.serviceID)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "AncillaryServices [serviceID=" + serviceID + ", magazine=" + magazine + ", headpillow=" + headpillow
				+ ", pets=" + pets + ", passengerflightdetails=" + passengerflightdetails + "]";
	}

	
}
