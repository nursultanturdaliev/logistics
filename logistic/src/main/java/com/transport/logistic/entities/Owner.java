package com.transport.logistic.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "owner", uniqueConstraints = { @UniqueConstraint(columnNames = "username") })
public class Owner implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
	@Column(name = "owner_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ownerId;

	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "phonenumber")
	private String phoneNumber;

	@OneToMany(mappedBy = "owner")
	private List<Truck> trucks = new ArrayList<>();

	@OneToMany(mappedBy = "owner")
	private List<Fracht> frachts = new ArrayList<>();
	
	@OneToMany(mappedBy = "owner")
	private List<LogisticPath> path = new ArrayList<>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Fracht> getFrachts() {
		return frachts;
	}

	public void setFrachts(List<Fracht> frachts) {
		this.frachts = frachts;
	}

	public Owner() {
		super();
	}

	public Owner(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
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

	@Override
	public String toString() {
		return "Owner [ownerId=" + ownerId + ", firstname=" + firstname + ", lastname=" + lastname + ", phoneNumber="
				+ phoneNumber + ", trucks=" + trucks + ", frachts=" + frachts + "]";
	}

}
