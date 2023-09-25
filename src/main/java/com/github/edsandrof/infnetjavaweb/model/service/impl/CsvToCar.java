package com.github.edsandrof.infnetjavaweb.model.service.impl;

import com.github.edsandrof.infnetjavaweb.model.domain.Car;
import com.github.edsandrof.infnetjavaweb.model.domain.Vehicle;
import com.github.edsandrof.infnetjavaweb.model.enums.CarDoors;
import com.github.edsandrof.infnetjavaweb.model.enums.FuelType;
import com.github.edsandrof.infnetjavaweb.model.service.CsvToVehicle;

import java.util.ArrayList;
import java.util.List;

public class CsvToCar implements CsvToVehicle {

    @Override
    public List<Vehicle> convert(List<String[]> content) {
        List<Vehicle> cars = new ArrayList<>();

        for (String[] cols : content) {
            cars.add(new Car(
                    Long.parseLong(cols[0]),
                    cols[1],
                    Integer.parseInt(cols[2]),
                    FuelType.safeValueOf(cols[3]),
                    Double.parseDouble(cols[4]),
                    CarDoors.safeValueOf(cols[5])
            ));
        }
        return cars;
    }
}
