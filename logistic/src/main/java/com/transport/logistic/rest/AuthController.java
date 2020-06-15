package com.transport.logistic.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transport.logistic.entities.Owner;
import com.transport.logistic.jwt.JwtUtils;
import com.transport.logistic.models.AuthenticationRequest;
import com.transport.logistic.models.AuthenticationResponse;
import com.transport.logistic.repo.OwnerRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtils jwtTokenUtil;
	
	@PostMapping("/signin")
	public ResponseEntity<?> signin(@RequestBody AuthenticationRequest request) throws Exception {
		Authentication authentication;
		try {
			authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
			);
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect Username or password");
		}
		
		Owner owner = ownerRepository.findByUsername(request.getUsername()).get();
		final String jwt = jwtTokenUtil.generateJwtToken(authentication);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt, owner));

	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody Owner owner) throws Exception {
		Authentication authentication;
		
		final boolean userExists = ownerRepository.existsByUsername(owner.getUsername());
		
		if(userExists) {
			return ResponseEntity.badRequest().body("Error: Username is already in use!");
		}else {
			Owner ow = ownerRepository.save(owner);
			try {
				authentication = authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(owner.getUsername(), owner.getPassword())
				);
			} catch (BadCredentialsException e) {
				throw new Exception("Incorrect Username or password");
			}
			
			final String jwt = jwtTokenUtil.generateJwtToken(authentication);
			
			return ResponseEntity.ok(new AuthenticationResponse(jwt, ow));
		}
		
	}

}
