package br.com.carlosjunior.registrationlogin.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import br.com.carlosjunior.registrationlogin.entities.User;
import br.com.carlosjunior.registrationlogin.entities.UserRole;
import br.com.carlosjunior.registrationlogin.repositories.UserRepository;
import br.com.carlosjunior.registrationlogin.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	//used to automatically wire bean dependencies in a Spring container
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
	    try {
	        User user = new User(registrationDto.getFirstName(), registrationDto.getLastName(),
	            registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPassword()),
	            Arrays.asList(new UserRole("ROLE_USER")));
	        return userRepository.save(user);
	    } catch (DataIntegrityViolationException e) {
	        throw new IllegalArgumentException("Email Id already exists!");
	    }
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(username);

		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password![1]");
		}

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<UserRole> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}
