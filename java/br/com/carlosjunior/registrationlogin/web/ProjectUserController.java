package br.com.carlosjunior.registrationlogin.web;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.carlosjunior.registrationlogin.entities.Project;
import br.com.carlosjunior.registrationlogin.exception.RecordNotFoundException;
import br.com.carlosjunior.registrationlogin.services.ProjectService;

@Controller
@RequestMapping("/userproject")
public class ProjectUserController 
{
	@Autowired
	ProjectService service;

	@RequestMapping
	public String getAllEmployees(Model model) 
	{	
		System.out.println("getAllEmployees");

		List<Project> list = service.getAllEmployees();

		model.addAttribute("employees", list);

		return "user-project";
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
	    return "user-project";
	}
}


