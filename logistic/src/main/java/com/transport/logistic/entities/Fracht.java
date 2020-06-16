package com.transport.logistic.entities;

import java.io.Serializable;
import java.security.Timestamp;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Fracht")
public class Fracht implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@Id()
	@Column(name="fracht_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int frachtId; 
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name="owner_id")
	@JsonIgnore
	private Owner owner;

	@Column(name="loaddescription")
	private String loadDescription; 
	
	@Column(name="weight")
	private double weight;
	
	@Column(name="origin")
	private String origin;
	
	@Column(name="destination")
	private String destination;
	
	public Fracht() {
		super();
	}



	public int getFrachtId() {
		return frachtId;
	}

	public void setFrachtId(int frachtId) {
		this.frachtId = frachtId;
	}

	public Owner getOwner() {
		return owner;
	}



	public void setOwner(Owner owner) {
		this.owner = owner;
	}




	public String getLoadDescription() {
		return loadDescription;
	}



	public void setLoadDescription(String loadDescription) {
		this.loadDescription = loadDescription;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	

}
