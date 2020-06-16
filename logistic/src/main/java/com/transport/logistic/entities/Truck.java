package com.transport.logistic.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="truck")
public class Truck implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@Id()
	@Column(name="truck_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name="owner_id")
	@JsonIgnore
	private Owner owner;
	
	@Column(name="weight")
	private double weight;
	
	@Column(name="trucktype")
	private String truckType;

	public Truck() {
		super();
	}
	
	

	public Truck(Owner owner, double weight, String truckType) {
		super();
		this.owner = owner;
		this.weight = weight;
		this.truckType = truckType;
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

	@Override
	public String toString() {
		return "Truck [id=" + id + ", owner=" + owner + ", weight=" + weight + ", truckType=" + truckType + "]";
	} 
	
	
	
}
