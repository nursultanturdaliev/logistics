package com.transport.logistic.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="truck")
public class Truck {
	
	@Id()
	@Column(name="truck_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 

	@ManyToOne
	@JoinColumn(name="owner", nullable=false, insertable=false, updatable=false, referencedColumnName="owner_id")
	private Owner owner;
	
	@Column(name="weight")
	private double weight;
	
	@Column(name="trucktype")
	private String truckType;

	public Truck() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getTruckType() {
		return truckType;
	}

	public void setTruckType(String truckType) {
		this.truckType = truckType;
	} 
	
	
	
}
