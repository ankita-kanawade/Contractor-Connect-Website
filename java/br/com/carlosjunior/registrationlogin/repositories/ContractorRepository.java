package br.com.carlosjunior.registrationlogin.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.carlosjunior.registrationlogin.entities.Contractor;


@Repository
public interface ContractorRepository 
			extends CrudRepository<Contractor, Long> {
	Contractor findByEmail(String email);
	
}
