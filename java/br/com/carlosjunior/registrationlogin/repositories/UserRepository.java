package br.com.carlosjunior.registrationlogin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carlosjunior.registrationlogin.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {

	User findByEmail(String email);
	
}