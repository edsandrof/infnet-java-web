package com.github.edsandrof.infnetjavaweb.application.controller;

import com.github.edsandrof.infnetjavaweb.infrastructure.util.Constant.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(value = "/")
	public String getHomePage() {
		return Page.HOME;
	}
	
	@GetMapping(value = "/login")
	public String getLoginPage() {
		return Page.LOGIN;
	}
}