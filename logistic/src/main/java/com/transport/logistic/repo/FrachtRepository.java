package com.transport.logistic.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.transport.logistic.entities.Fracht;
import com.transport.logistic.entities.Truck;

public interface FrachtRepository extends JpaRepository<Fracht, Integer>{

	@Query(value = "select * from fracht t where t.owner_id=?1", nativeQuery = true)
	List<Truck> findFrachtsByOwnerId(int ownerid);
}
