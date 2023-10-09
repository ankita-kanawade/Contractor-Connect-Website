package br.com.carlosjunior.registrationlogin.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carlosjunior.registrationlogin.entities.Project;
import br.com.carlosjunior.registrationlogin.exception.RecordNotFoundException;
import br.com.carlosjunior.registrationlogin.repositories.ProjectRepository;


@Service
public class ProjectService {

	@Autowired
	ProjectRepository repository;

	public List<Project> getAllEmployees()
	{
		System.out.println("getAllEmployees");
		List<Project> result = (List<Project>) repository.findAll();

		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<Project>();
		}
	}


	public Project getEmployeeById(Long id) throws RecordNotFoundException 
	{
		System.out.println("getEmployeeById");
		Optional<Project> employee = repository.findById(id);

		if(employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No Project record exist for given id");
		}
	}

	public Project createOrUpdateEmployee(Project entity) 
	{
		System.out.println("createOrUpdateEmployee");
		// Create new entry 
		if(entity.getId()  == null) 
		{
			entity = repository.save(entity);

			return entity;
		} 
		else 
		{
			// update existing entry 
			Optional<Project> project = repository.findById(entity.getId());

			if(project.isPresent()) 
			{
				Project newProject = project.get();
				newProject.setBudget(entity.getBudget());
				newProject.setDuration(entity.getDuration());
				newProject.setScope(entity.getScope());

				newProject = repository.save(newProject);

				return newProject;
			} else {
				entity = repository.save(entity);

				return entity;
			}
		}
	} 
	public void deleteEmployeeById(Long id) throws RecordNotFoundException 
	{
		System.out.println("deleteEmployeeById");

		Optional<Project> employee = repository.findById(id);

		if(employee.isPresent()) 
		{
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	} 
}