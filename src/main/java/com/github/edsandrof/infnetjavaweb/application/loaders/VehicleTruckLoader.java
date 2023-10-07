package com.github.edsandrof.infnetjavaweb.application.loaders;

import com.github.edsandrof.infnetjavaweb.model.domain.Vehicle;
import com.github.edsandrof.infnetjavaweb.model.service.CsvService;
import com.github.edsandrof.infnetjavaweb.model.service.CsvToType;
import com.github.edsandrof.infnetjavaweb.model.service.impl.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.github.edsandrof.infnetjavaweb.infrastructure.util.Constant.FILE_PATH;

@Order(3)
@Component
public class VehicleTruckLoader implements ApplicationRunner {

    private final VehicleServiceImpl vehicleService;
    private final CsvService csvService;
    private final CsvToType<Vehicle> csvToTruck;

    @Autowired
    public VehicleTruckLoader(VehicleServiceImpl vehicleService, CsvService csvService, CsvToType<Vehicle> csvToTruck) {
        this.vehicleService = vehicleService;
        this.csvService = csvService;
        this.csvToTruck = csvToTruck;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("loading trucks to database");

        List<String[]> csvTrucks = csvService.readFile(FILE_PATH + "/trucks.csv");

        List<Vehicle> trucks = csvService.loadType(csvTrucks, csvToTruck);
        trucks = vehicleService.registerAll(trucks);
    }
}
