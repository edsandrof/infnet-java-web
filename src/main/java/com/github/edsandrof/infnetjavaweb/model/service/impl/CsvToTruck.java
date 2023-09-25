package com.github.edsandrof.infnetjavaweb.model.service.impl;

import com.github.edsandrof.infnetjavaweb.model.domain.Truck;
import com.github.edsandrof.infnetjavaweb.model.domain.Vehicle;
import com.github.edsandrof.infnetjavaweb.model.enums.FuelType;
import com.github.edsandrof.infnetjavaweb.model.service.CsvToVehicle;

import java.util.ArrayList;
import java.util.List;

public class CsvToTruck implements CsvToVehicle {

    @Override
    public List<Vehicle> convert(List<String[]> content) {
        List<Vehicle> trucks = new ArrayList<>();

        for (String[] cols : content) {
            trucks.add(new Truck(
                    Long.parseLong(cols[0]),
                    cols[1],
                    Integer.parseInt(cols[2]),
                    FuelType.safeValueOf(cols[3]),
                    Double.parseDouble(cols[4]),
                    Integer.parseInt(cols[5]),
                    Integer.parseInt(cols[6])
            ));
        }
        return trucks;
    }
}
