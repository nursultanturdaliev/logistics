package com.transport.logistic.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="owner")
public class Owner {
	
	@Id()
	@Column(name="owner_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ownerId; 
	
	@Column(name="firstname")
	private String firstName; 
	
	@Column(name="lastname")
	private String lastname; 
	
	@Column(name="phonenumber")
	private String phoneNumber;
	
	@OneToMany(mappedBy="owner")
	private List<Truck> trucks;
	
	@OneToMany(mappedBy="owner")
	private List<Fracht> frachts;
	

	public List<Fracht> getFrachts() {
		return frachts;
	}

	public void setFrachts(List<Fracht> frachts) {
		this.frachts = frachts;
	}

	public Owner() {
		super();
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Truck> getTrucks() {
		return trucks;
	}

	public void setTrucks(List<Truck> trucks) {
		this.trucks = trucks;
	}
	
	

}
