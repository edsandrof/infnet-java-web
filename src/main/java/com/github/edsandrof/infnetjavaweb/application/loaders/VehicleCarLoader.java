package com.github.edsandrof.infnetjavaweb.application.loaders;

import com.github.edsandrof.infnetjavaweb.model.domain.Vehicle;
import com.github.edsandrof.infnetjavaweb.model.service.CsvService;
import com.github.edsandrof.infnetjavaweb.model.service.impl.CsvToCar;
import com.github.edsandrof.infnetjavaweb.model.service.impl.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.github.edsandrof.infnetjavaweb.infrastructure.util.Constant.FILE_PATH;

@Order(1)
@Component
public class VehicleCarLoader implements ApplicationRunner {

    private final VehicleServiceImpl vehicleService;
    private final CsvService csvService;

    @Autowired
    public VehicleCarLoader(VehicleServiceImpl vehicleService, CsvService csvService) {
        this.vehicleService = vehicleService;
        this.csvService = csvService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("loading cars to database");

        List<String[]> csvCars = csvService.readFile(FILE_PATH + "/cars.csv");

        List<Vehicle> cars = csvService.loadType(csvCars, new CsvToCar());
        cars = vehicleService.registerAll(cars);
    }
}
