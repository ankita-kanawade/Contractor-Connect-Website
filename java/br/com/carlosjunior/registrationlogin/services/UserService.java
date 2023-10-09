package br.com.carlosjunior.registrationlogin.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.com.carlosjunior.registrationlogin.entities.User;
import br.com.carlosjunior.registrationlogin.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
//interface provided by Spring Security that is used to retrieve user 
//details from a data source, such as a database 
	User save(UserRegistrationDto registrationDto);
	
}
