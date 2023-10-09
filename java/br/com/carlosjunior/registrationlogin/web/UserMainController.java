package br.com.carlosjunior.registrationlogin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserMainController {

	@GetMapping("/userlogin")
	public String login() {
		return "user-login";
	}

	@GetMapping("/MainFile")
	public String home() {
		return "MainFile";
	}
	@GetMapping("/gallary")
	public String showGallary() {
		// Return the admin dashboard page
		return "gallary";
	}
	@GetMapping("/success")
	public String Success() {
		// Return the admin dashboard page
		return "success";
	}
}
