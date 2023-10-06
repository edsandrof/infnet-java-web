package com.github.edsandrof.infnetjavaweb.model.service.impl;

import com.github.edsandrof.infnetjavaweb.model.domain.Car;
import com.github.edsandrof.infnetjavaweb.model.domain.Vehicle;
import com.github.edsandrof.infnetjavaweb.model.enums.CarDoors;
import com.github.edsandrof.infnetjavaweb.model.enums.Color;
import com.github.edsandrof.infnetjavaweb.model.enums.FuelType;
import com.github.edsandrof.infnetjavaweb.model.service.CsvToType;

import java.util.ArrayList;
import java.util.List;

public class CsvToCar implements CsvToType<Vehicle> {

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
                    Double.parseDouble(cols[5]),
                    CarDoors.safeValueOf(cols[6]),
                    Color.safeValueOf(cols[7]),
                    Boolean.parseBoolean(cols[8])
            ));
        }
        return cars;
    }
}
