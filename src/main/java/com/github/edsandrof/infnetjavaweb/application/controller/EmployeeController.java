package com.github.edsandrof.infnetjavaweb.application.controller;

import com.github.edsandrof.infnetjavaweb.infrastructure.util.Constant.Page;
import com.github.edsandrof.infnetjavaweb.model.domain.Employee;
import com.github.edsandrof.infnetjavaweb.model.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/employee")
@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String getListPage(Model model) {
        model.addAttribute("employees", employeeService.listAll());
        return Page.EMPLOYEE_LIST;
    }

    @GetMapping(value = "/register")
    public String getRegisterPage() {
        return Page.EMPLOYEE_REGISTER;
    }

    @PostMapping(value = "/register")
    public String register(Employee employee) {
        employeeService.register(employee);

        return Page.REDIRECT;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        employeeService.delete(id);

        return Page.REDIRECT + Page.EMPLOYEE_LIST;
    }
}