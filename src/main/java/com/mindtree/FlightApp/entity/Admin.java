package com.mindtree.FlightApp.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Admin {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "admin_id" )
	private String adminID;
	@Column(name = "companyName")
	private String companyName;
	@Column(name = "password")
	private String password;
	@Column(name="role")
	private int role;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.PERSIST, mappedBy="admin", fetch=FetchType.EAGER)
	private List<Flights> flight;

	public Admin() {
		super();
	}
	public String getAdminID() {
		return adminID;
	}
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Flights> getFlight() {
		return flight;
	}
	public void setFlight(List<Flights> flight) {
		this.flight = flight;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public Admin(String adminID, String companyName, String password, int role, List<Flights> flight) {
		super();
		this.adminID = adminID;
		this.companyName = companyName;
		this.password = password;
		this.role = role;
		this.flight = flight;
	}
	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", companyName=" + companyName + ", password=" + password + ", role="
				+ role + ", flight=" + flight + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminID == null) ? 0 : adminID.hashCode());
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((flight == null) ? 0 : flight.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + role;
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
		Admin other = (Admin) obj;
		if (adminID == null) {
			if (other.adminID != null)
				return false;
		} else if (!adminID.equals(other.adminID))
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (flight == null) {
			if (other.flight != null)
				return false;
		} else if (!flight.equals(other.flight))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role != other.role)
			return false;
		return true;
	}
	
	
	
}
