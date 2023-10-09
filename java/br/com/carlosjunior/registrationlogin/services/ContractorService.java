package br.com.carlosjunior.registrationlogin.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carlosjunior.registrationlogin.entities.Contractor;
import br.com.carlosjunior.registrationlogin.exception.RecordNotFoundException;
import br.com.carlosjunior.registrationlogin.repositories.ContractorRepository;

@Service
public class ContractorService {
	
	@Autowired
	ContractorRepository repository;
	public List<Contractor> getAllEmployees()
	{
		System.out.println("getAllEmployees");
		List<Contractor> result = (List<Contractor>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<Contractor>();
		}
	}

	
	public Contractor getEmployeeById(Long id) throws RecordNotFoundException 
	{
		System.out.println("getEmployeeById");
		Optional<Contractor> employee = repository.findById(id);
		
		if(employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No Contractor record exist for given id");
		}
	}
	
	public Contractor createOrUpdateEmployee(Contractor entity) 
	{
		System.out.println("createOrUpdateEmployee");
		// Create new entry
Contractor existingContractor = repository.findByEmail(entity.getEmail());
        
        if (existingContractor != null) {
            System.out.println("Email ID already exists");
            return null;
        }
        
		if(entity.getId()  == null) 
		{
			entity = repository.save(entity);
			
			return entity;
		} 
		else 
		{
			// update existing entry 
			Optional<Contractor> employee = repository.findById(entity.getId());
			
			if(employee.isPresent()) 
			{
				Contractor newEntity = employee.get();
				newEntity.setEmail(entity.getEmail());
				newEntity.setFirstName(entity.getFirstName());
				newEntity.setContact_Number(entity.getContact_Number());
				newEntity.setCompany_Name(entity.getCompany_Name());
				newEntity.setCompany_Address(entity.getCompany_Address());
				newEntity.setBusiness_regNo(entity.getBusiness_regNo());
				newEntity.setAbout_Company(entity.getAbout_Company());

				newEntity = repository.save(newEntity);
				
				return newEntity;
			} else {
				entity = repository.save(entity);
				
				return entity;
			}
		}
	} 
	
	public void deleteEmployeeById(Long id) throws RecordNotFoundException 
	{
		System.out.println("deleteEmployeeById");
		
		Optional<Contractor> employee = repository.findById(id);
		
		if(employee.isPresent()) 
		{
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	} 
}