package com.mindtree.FlightApp.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.junit.jupiter.params.converter.JavaTimeConversionPattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Passengerbookingdetails {

	@Id
	@Column(name="booking_id")
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",
	  strategy = "uuid")
	private String bookingID;
	
	@Column(name="PNR")
	private String pnr;
	
	@Column(name="name")
	private String name;
	
	@Column(name="age")
	private int age;
	
	@Column(name="passport")
	private boolean passport;
	

	@Column(name="DOB")
	private Date dob;
	
	@Column(name="address")
	private String address;
	
	@JsonIgnoreProperties("passengerbookingdetails")
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Passengerflightdetails passengerflightdetails;
	
	public Passengerbookingdetails() {
		super();
	}
	public Passengerbookingdetails(String bookingID, String pnr, String name, int age, boolean passport, Date dob,
			String address, Passengerflightdetails passengerflightdetails) {
		super();
		this.bookingID = bookingID;
		this.pnr = pnr;
		this.name = name;
		this.age = age;
		this.passport = passport;
		this.dob = dob;
		this.address = address;
		this.passengerflightdetails = passengerflightdetails;
	}
	
	public String getBookingID() {
		return bookingID;
	}
	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isPassport() {
		return passport;
	}
	public void setPassport(boolean passport) {
		this.passport = passport;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Passengerflightdetails getPassengerflightdetails() {
		return passengerflightdetails;
	}
	public void setPassengerflightdetails(Passengerflightdetails passengerflightdetails) {
		this.passengerflightdetails = passengerflightdetails;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + ((bookingID == null) ? 0 : bookingID.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((passengerflightdetails == null) ? 0 : passengerflightdetails.hashCode());
		result = prime * result + (passport ? 1231 : 1237);
		result = prime * result + ((pnr == null) ? 0 : pnr.hashCode());
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
		Passengerbookingdetails other = (Passengerbookingdetails) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age != other.age)
			return false;
		if (bookingID == null) {
			if (other.bookingID != null)
				return false;
		} else if (!bookingID.equals(other.bookingID))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (passengerflightdetails == null) {
			if (other.passengerflightdetails != null)
				return false;
		} else if (!passengerflightdetails.equals(other.passengerflightdetails))
			return false;
		if (passport != other.passport)
			return false;
		if (pnr == null) {
			if (other.pnr != null)
				return false;
		} else if (!pnr.equals(other.pnr))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Passengerbookingdetails [bookingID=" + bookingID + ", pnr=" + pnr + ", name=" + name + ", age=" + age
				+ ", passport=" + passport + ", dob=" + dob + ", address=" + address + ", passengerflightdetails="
				+ passengerflightdetails + "]";
	}
}
