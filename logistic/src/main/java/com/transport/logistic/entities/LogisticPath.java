package com.transport.logistic.entities;

import java.io.Serializable;
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


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="logisticpath")
public class LogisticPath implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id()
	@Column(name="path_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pathId; 
	
	@Column(name="description")
	private String desription;
	
	@Column(name="origin")
	private String origin; 
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="starttime")
	private Date startTtime;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name="owner_id")
	@JsonIgnore
	private Owner owner;
	

	public LogisticPath(String desription) {
		super();
		this.desription = desription;
	}

	public String getDesription() {
		return desription;
	}

	public void setDesription(String desription) {
		this.desription = desription;
	}

	public int getPathId() {
		return pathId;
	}

	public void setPathId(int pathId) {
		this.pathId = pathId;
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

	public Date getStartTtime() {
		return startTtime;
	}

	public void setStartTtime(Date startTtime) {
		this.startTtime = startTtime;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	
}
