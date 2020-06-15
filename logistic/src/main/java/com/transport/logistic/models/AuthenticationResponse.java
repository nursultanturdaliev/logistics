package com.transport.logistic.models;

import com.transport.logistic.entities.Owner;

public class AuthenticationResponse {
	
	
	private final String jwt;
	
	private Owner owner;

	public AuthenticationResponse(String jwt) {
		this.jwt = jwt;
	}
	
	public AuthenticationResponse(String jwt, Owner owner) {
		this.jwt = jwt;
		this.owner = owner;
	}


	public String getJwt() {
		return jwt;
	} 
	
	public Owner getOwner() {
		return owner;
	}

}
