package br.com.carlosjunior.registrationlogin.web;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.carlosjunior.registrationlogin.entities.Contractor;
import br.com.carlosjunior.registrationlogin.exception.RecordNotFoundException;
import br.com.carlosjunior.registrationlogin.services.ContractorService;

@Controller
@RequestMapping("/contractor")
public class ContractorController 
{
	@Autowired
	ContractorService service;

	@RequestMapping
	public String getAllEmployees(Model model) 
	{	
		System.out.println("getAllEmployees");

		List<Contractor> list = service.getAllEmployees();

		model.addAttribute("employees", list);

		return "list-employees";
	}




	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editEmployeeById(Model model, @PathVariable("id") Optional<Long> id) 
			throws RecordNotFoundException
	{

		System.out.println("editEmployeeById" + id);
		if (id.isPresent()) {
			Contractor entity = service.getEmployeeById(id.get());
			model.addAttribute("employee", entity);
		} else {
			model.addAttribute("employee", new Contractor());
		}


		return "add-edit-employee";
	}

	@RequestMapping(path = "/delete/{id}")
	public String deleteEmployeeById(Model model, @PathVariable("id") Long id) 
			throws RecordNotFoundException 
	{

		System.out.println("deleteEmployeeById" + id);

		service.deleteEmployeeById(id);
		return "redirect:/contractor";
	}

	@RequestMapping(path = "/createEmployee", method = RequestMethod.POST)
	public String createOrUpdateEmployee(Contractor employee) 
	{
		System.out.println("createOrUpdateEmployee ");
		Contractor createdEmployee = service.createOrUpdateEmployee(employee);

		if (createdEmployee == null) {
			return "redirect:/contractor/edit?error";
		} else {
			service.createOrUpdateEmployee(employee);
			return "redirect:/contractor";
		}
	}
	@RequestMapping(path = "/search", method = RequestMethod.GET)
	public String searchEmployeeById(Model model, @RequestParam("id") Optional<Long> id) {
	    System.out.println("searchEmployeeById: " + id);
	    try {
	        if (id.isPresent()) {
	            Contractor employee = service.getEmployeeById(id.get());
	            model.addAttribute("employees", Collections.singletonList(employee));
	        } else {
	            model.addAttribute("employees", Collections.emptyList());
	        }
	    } catch (RecordNotFoundException e) {
	        model.addAttribute("errorMessage", e.getMessage());
	        model.addAttribute("employees", Collections.emptyList());
	    }
	    return "list-employees";
	}

	
}
