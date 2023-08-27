package main.java.edsandrof.infnetjavaoo.service;

import main.java.edsandrof.infnetjavaoo.model.Motorcycle;
import main.java.edsandrof.infnetjavaoo.model.Vehicle;
import main.java.edsandrof.infnetjavaoo.model.enums.FuelType;

import java.util.ArrayList;
import java.util.List;

public class CsvToMotorcycle implements CsvToVehicle {

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
