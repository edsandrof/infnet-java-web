package main.java.edsandrof.infnetjavaoo.service;

import main.java.edsandrof.infnetjavaoo.model.Vehicle;

import java.util.List;

public interface CsvToVehicle {
    List<Vehicle> convert(List<String[]> content);
}
