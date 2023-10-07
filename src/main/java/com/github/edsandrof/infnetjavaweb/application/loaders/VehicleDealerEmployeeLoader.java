package com.github.edsandrof.infnetjavaweb.application.loaders;

import com.github.edsandrof.infnetjavaweb.model.domain.Employee;
import com.github.edsandrof.infnetjavaweb.model.service.CsvService;
import com.github.edsandrof.infnetjavaweb.model.service.CsvToType;
import com.github.edsandrof.infnetjavaweb.model.service.EmployeeService;
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
    private final CsvToType<Employee> csvToEmployee;

    @Autowired
    public VehicleDealerEmployeeLoader(EmployeeService employeeService, CsvService csvService, CsvToType<Employee> csvToEmployee) {
        this.employeeService = employeeService;
        this.csvService = csvService;
        this.csvToEmployee = csvToEmployee;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("loading vehicle dealer employees to database");

        List<String[]> csvEmployees = csvService.readFile(FILE_PATH + "/employees.csv");
        List<Employee> employees = csvService.loadType(csvEmployees, csvToEmployee);

        employeeService.registerAll(employees);
        System.out.println("load finished");
    }
}
