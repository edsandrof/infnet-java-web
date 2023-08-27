package main.java.edsandrof.infnetjavaoo.service.impl;

import main.java.edsandrof.infnetjavaoo.model.Truck;
import main.java.edsandrof.infnetjavaoo.model.Vehicle;
import main.java.edsandrof.infnetjavaoo.model.enums.FuelType;
import main.java.edsandrof.infnetjavaoo.service.CsvToVehicle;

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
