package com.github.edsandrof.infnetjavaweb.application.controller;

import com.github.edsandrof.infnetjavaweb.infrastructure.util.Constant.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

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

	@GetMapping(value = "/logout")
	public String logout(HttpSession httpSession, SessionStatus sessionStatus) {

		sessionStatus.setComplete();
		httpSession.removeAttribute("employee");

		return Page.HOME;
	}
}