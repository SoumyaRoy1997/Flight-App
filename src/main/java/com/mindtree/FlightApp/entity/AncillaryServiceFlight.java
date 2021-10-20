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
public class AncillaryServiceFlight {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="serviceID")
	private int serviceID;
	
	@Column(name="serviceName")
	private String serviceName;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.PERSIST )
	private Flights flight;

	public AncillaryServiceFlight(int serviceID, String serviceName, Flights flight) {
		super();
		this.serviceID = serviceID;
		this.serviceName = serviceName;
		this.flight = flight;
	}

	public AncillaryServiceFlight() {
		super();
	}

	@Override
	public String toString() {
		return "AncillaryServiceFlight [serviceID=" + serviceID + ", serviceName=" + serviceName + ", flight=" + flight
				+ "]";
	}

	public int getServiceID() {
		return serviceID;
	}

	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Flights getFlight() {
		return flight;
	}

	public void setFlight(Flights flight) {
		this.flight = flight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flight == null) ? 0 : flight.hashCode());
		result = prime * result + serviceID;
		result = prime * result + ((serviceName == null) ? 0 : serviceName.hashCode());
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
		AncillaryServiceFlight other = (AncillaryServiceFlight) obj;
		if (flight == null) {
			if (other.flight != null)
				return false;
		} else if (!flight.equals(other.flight))
			return false;
		if (serviceID != other.serviceID)
			return false;
		if (serviceName == null) {
			if (other.serviceName != null)
				return false;
		} else if (!serviceName.equals(other.serviceName))
			return false;
		return true;
	}
	
	
}
