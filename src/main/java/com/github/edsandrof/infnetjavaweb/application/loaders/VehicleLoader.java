package com.github.edsandrof.infnetjavaweb.application.loaders;

import com.github.edsandrof.infnetjavaweb.model.domain.Vehicle;
import com.github.edsandrof.infnetjavaweb.model.service.CsvService;
import com.github.edsandrof.infnetjavaweb.model.service.VehicleService;
import com.github.edsandrof.infnetjavaweb.model.service.impl.CsvToCar;
import com.github.edsandrof.infnetjavaweb.model.service.impl.CsvToMotorcycle;
import com.github.edsandrof.infnetjavaweb.model.service.impl.CsvToTruck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.github.edsandrof.infnetjavaweb.infrastructure.util.Constant.FILE_PATH;

@Order(1)
@Component
public class VehicleLoader implements ApplicationRunner {

    private final VehicleService vehicleService;
    private final CsvService csvService;

    @Autowired
    public VehicleLoader(VehicleService vehicleService, CsvService csvService) {
        this.vehicleService = vehicleService;
        this.csvService = csvService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String[]> csvCars = csvService.readFile(FILE_PATH + "/cars.csv");
        List<String[]> csvTrucks = csvService.readFile(FILE_PATH + "/trucks.csv");
        List<String[]> csvMotorcycle = csvService.readFile(FILE_PATH + "/motorcycles.csv");

        List<Vehicle> allVehicles = new ArrayList<>();
        allVehicles.addAll(csvService.loadType(csvCars, new CsvToCar()));
        allVehicles.addAll(csvService.loadType(csvTrucks, new CsvToTruck()));
        allVehicles.addAll(csvService.loadType(csvMotorcycle, new CsvToMotorcycle()));

        allVehicles = vehicleService.registerAll(allVehicles);
    }
}
