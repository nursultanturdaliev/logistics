package com.transport.logistic.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transport.logistic.entities.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer>{

	Optional<Owner> findByUsername(String username);

	Boolean existsByUsername(String username);
}
