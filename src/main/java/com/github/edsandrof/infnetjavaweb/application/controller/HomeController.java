package com.github.edsandrof.infnetjavaweb.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(value = "/")
	public String getHomeRoute() {
		return "home";
	}
	
	@GetMapping(value = "/login")
	public String getLoginRoute() {
		return "login";
	}
}