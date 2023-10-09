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

import br.com.carlosjunior.registrationlogin.entities.Project;
import br.com.carlosjunior.registrationlogin.exception.RecordNotFoundException;
import br.com.carlosjunior.registrationlogin.services.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController 
{
	@Autowired
	ProjectService service;

	@RequestMapping
	public String getAllEmployees(Model model) 
	{	
		System.out.println("getAllEmployees");

		List<Project> list = service.getAllEmployees();

		model.addAttribute("employees", list);

		return "list-project";
	}




	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editEmployeeById(Model model, @PathVariable("id") Optional<Long> id) 
			throws RecordNotFoundException
	{

		System.out.println("editEmployeeById" + id);
		if (id.isPresent()) {
			Project entity = service.getEmployeeById(id.get());
			model.addAttribute("employee", entity);
		} else {
			model.addAttribute("employee", new Project());
		}


		return "add-edit-project";
	}

	@RequestMapping(path = "/delete/{id}")
	public String deleteEmployeeById(Model model, @PathVariable("id") Long id) 
			throws RecordNotFoundException 
	{

		System.out.println("deleteEmployeeById" + id);

		service.deleteEmployeeById(id);
		return "redirect:/project";
	}

	@RequestMapping(path = "/createEmployee", method = RequestMethod.POST)
	public String createOrUpdateEmployee(Project employee) 
	{
		System.out.println("createOrUpdateEmployee ");

		service.createOrUpdateEmployee(employee);

		return "redirect:/project";
	}
	@RequestMapping(path = "/search", method = RequestMethod.GET)
	public String searchEmployeeById(Model model, @RequestParam("id") Optional<Long> id) {
	    System.out.println("searchEmployeeById: " + id);
	    try {
	        if (id.isPresent()) {
	            Project employee = service.getEmployeeById(id.get());
	            model.addAttribute("employees", Collections.singletonList(employee));
	        } else {
	            model.addAttribute("employees", Collections.emptyList());
	        }
	    } catch (RecordNotFoundException e) {
	        model.addAttribute("errorMessage", e.getMessage());
	        model.addAttribute("employees", Collections.emptyList());
	    }
	    return "list-project";
	}
}

