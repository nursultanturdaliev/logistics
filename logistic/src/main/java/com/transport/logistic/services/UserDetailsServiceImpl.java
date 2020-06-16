package com.transport.logistic.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transport.logistic.entities.Owner;
import com.transport.logistic.repo.OwnerRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	OwnerRepository ownerRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Owner owner =  ownerRepository.findByUsername(username).get();
		return UserDetailsImpl.build(owner);
	}
	

	public boolean existsByUsername(String username) throws UsernameNotFoundException {
		Owner owner =  ownerRepository.findById(1).get();
		return owner != null ? true : false;
	}

	

}
