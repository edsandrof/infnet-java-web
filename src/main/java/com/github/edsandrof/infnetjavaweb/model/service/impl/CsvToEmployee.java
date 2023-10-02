package com.github.edsandrof.infnetjavaweb.model.service.impl;

import com.github.edsandrof.infnetjavaweb.model.domain.Employee;
import com.github.edsandrof.infnetjavaweb.model.service.CsvToType;

import java.util.ArrayList;
import java.util.List;

public class CsvToEmployee implements CsvToType<Employee> {

    @Override
    public List<Employee> convert(List<String[]> content) {
        List<Employee> employees = new ArrayList<>();

        for (String[] cols : content) {
            employees.add(new Employee(
                    Long.parseLong(cols[0]),
                    cols[1],
                    cols[2],
                    cols[3]
            ));
        }
        return employees;
    }
}
