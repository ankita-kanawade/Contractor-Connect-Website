package br.com.carlosjunior.registrationlogin.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.carlosjunior.registrationlogin.entities.Project;



@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{

}
