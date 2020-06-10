package com.tutorial.springboot.security.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tutorial.springboot.security.model.User;
import com.tutorial.springboot.security.model.UserRepository;


@Service
public class MyUserDetailService implements UserDetailsService{
	
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);
		user.orElseThrow(() -> new UsernameNotFoundException("UserName "+username+" Not Found"));
		return user.map(MyUserDetail::new).get();
	}

}
