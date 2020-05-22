package com.transport.logistic.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transport.logistic.entities.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Integer>{

}
