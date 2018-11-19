package com.olive.controllers;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	
	
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	

	/*@RequestMapping("/home")
	public String home(Model model) {
		return "userlist";
	}*/
	
	@RequestMapping("/login")
	public String login(Model model) {
		return "public/login";		
	}
	
	
	@RequestMapping("/errorpage")
	public String error(Model model) {
		return "public/error";
	}


	
}
