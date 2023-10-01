package com.github.edsandrof.infnetjavaweb.model.service.impl;

import com.github.edsandrof.infnetjavaweb.model.domain.Motorcycle;
import com.github.edsandrof.infnetjavaweb.model.domain.Vehicle;
import com.github.edsandrof.infnetjavaweb.model.enums.FuelType;
import com.github.edsandrof.infnetjavaweb.model.service.CsvToType;

import java.util.ArrayList;
import java.util.List;

public class CsvToMotorcycle implements CsvToType<Vehicle> {

    @Override
    public List<Vehicle> convert(List<String[]> content) {
        List<Vehicle> motorcycles = new ArrayList<>();

        for (String[] cols : content) {
            motorcycles.add(new Motorcycle(
                    Long.parseLong(cols[0]),
                    cols[1],
                    Integer.parseInt(cols[2]),
                    FuelType.safeValueOf(cols[3]),
                    Double.parseDouble(cols[4]),
                    Boolean.getBoolean(cols[5])
            ));
        }
        return motorcycles;
    }
}
