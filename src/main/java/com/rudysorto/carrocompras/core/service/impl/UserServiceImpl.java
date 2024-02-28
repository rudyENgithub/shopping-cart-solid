package com.rudysorto.carrocompras.core.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rudysorto.carrocompras.core.service.IUserService;
import com.rudysorto.carrocompras.database.dao.IUserDAO;
import com.rudysorto.carrocompras.database.domain.User;

/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: service used for the business logic of the users
*/
@Service
public class UserServiceImpl implements IUserService, UserDetailsService{
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	IUserDAO userRepository;
	
	/*
	Author: Rudy Sorto rudy.eli.ayala@gmail.com
	Objective: method used to retrieve user data by username, their roles and other by user
	*/
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		
		if(user == null) {
			logger.error("Login Error: the user '"+username+"' does not exist  in the system!");
			throw new UsernameNotFoundException("Login Error: the user '"+username+"' does not exist  in the system!");
		}
		
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.peek(authority -> logger.info("Role: " + authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
	}

	@Override
	@Transactional(readOnly=true)
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
