package com.github.edsandrof.infnetjavaweb.application.loaders;

import com.github.edsandrof.infnetjavaweb.model.domain.Employee;
import com.github.edsandrof.infnetjavaweb.model.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(7)
@Component
public class UpdateEmployeeLoader implements ApplicationRunner {

    private final EmployeeService employeeService;

    @Autowired
    public UpdateEmployeeLoader(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("updating vehicle dealer employee");

        Employee firstEmployee = employeeService.findByEmail("admin@allcars.com");
        firstEmployee.setEmail("updated@allcars.com");
        firstEmployee.setPassword("321");

        employeeService.update(firstEmployee);
        System.out.println("load finished");
    }
}
