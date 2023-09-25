package com.github.edsandrof.infnetjavaweb.model.service;

import com.github.edsandrof.infnetjavaweb.model.domain.Vehicle;

import java.util.List;

public interface CsvToVehicle {
    List<Vehicle> convert(List<String[]> content);
}
