package com.github.edsandrof.infnetjavaweb.application.loaders;

import com.github.edsandrof.infnetjavaweb.model.Employee;
import com.github.edsandrof.infnetjavaweb.model.service.CsvService;
import com.github.edsandrof.infnetjavaweb.model.service.EmployeeService;
import com.github.edsandrof.infnetjavaweb.model.service.impl.CsvToEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.github.edsandrof.infnetjavaweb.infrastructure.util.Constant.FILE_PATH;

@Order(6)
@Component
public class VehicleDealerEmployeeLoader implements ApplicationRunner {

    private final EmployeeService employeeService;
    private final CsvService csvService;

    @Autowired
    public VehicleDealerEmployeeLoader(EmployeeService employeeService, CsvService csvService) {
        this.employeeService = employeeService;
        this.csvService = csvService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("loading vehicle dealer employees to database");

        List<String[]> csvEmployees = csvService.readFile(FILE_PATH + "/employees.txt");
        List<Employee> employees = csvService.loadType(csvEmployees, new CsvToEmployee());

        employeeService.registerAll(employees);
    }
}
