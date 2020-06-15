package com.transport.logistic.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.transport.logistic.entities.Truck;

public interface TruckRepository extends JpaRepository<Truck, Integer>{
	
	@Query(value = "select * from truck t where t.owner_id=?1", nativeQuery = true)
	List<Truck> findTrucksByOwnerId(int ownerid);

}
