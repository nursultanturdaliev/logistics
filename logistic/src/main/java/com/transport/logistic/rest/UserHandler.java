package com.transport.logistic.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.transport.logistic.entities.Fracht;
import com.transport.logistic.entities.Owner;
import com.transport.logistic.entities.Truck;
import com.transport.logistic.repo.FrachtRepository;
import com.transport.logistic.repo.OwnerRepository;
import com.transport.logistic.repo.TruckRepository;


@RestController
public class UserHandler {
	
	@Autowired
    private FrachtRepository frachtRepository;
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	@Autowired
	private TruckRepository truckRepository;
	
	
	
	@GetMapping("/api/{ownerid}/getOwnerById")
	public Owner getLoad(@PathVariable (value="ownerid") int ownerid) {
		return ownerRepository.findById(ownerid).get();
	}
	
	
	@GetMapping("/api/{ownerid}/getAllTracks")
	public List<Truck> getAllTrucks(@PathVariable (value="ownerid") int ownerid) {    
        return truckRepository.findTrucksByOwnerId(ownerid);
	}
	
	
	@GetMapping("/api/{ownerid}/getAllLoads")
	public List<Truck> getAllLoad(@PathVariable (value="ownerid") int ownerid) {    
        return frachtRepository.findFrachtsByOwnerId(ownerid);
	}
	
		
	@PostMapping(value="/api/{ownerid}/add-fracht-to-owner", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Fracht addFracht(@PathVariable (value="ownerid") int ownerid, @RequestBody Fracht fracht) {
		Owner owner = ownerRepository.findById(ownerid).get();
		fracht.setOwner(owner);
		return frachtRepository.save(fracht);
	}
	
	
	@PostMapping(value="/api/{ownerid}/add-truck-to-owner", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Truck addFracht(@PathVariable (value="ownerid") int ownerid, @RequestBody Truck truck) {
		Owner owner = ownerRepository.findById(ownerid).get();
		truck.setOwner(owner);
		return truckRepository.save(truck);
	}
}
 