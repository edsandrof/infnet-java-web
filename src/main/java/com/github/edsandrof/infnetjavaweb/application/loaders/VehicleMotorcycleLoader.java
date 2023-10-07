package com.github.edsandrof.infnetjavaweb.application.loaders;

import com.github.edsandrof.infnetjavaweb.model.domain.Vehicle;
import com.github.edsandrof.infnetjavaweb.model.service.CsvService;
import com.github.edsandrof.infnetjavaweb.model.service.impl.CsvToMotorcycle;
import com.github.edsandrof.infnetjavaweb.model.service.impl.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.github.edsandrof.infnetjavaweb.infrastructure.util.Constant.FILE_PATH;

@Order(2)
@Component
public class VehicleMotorcycleLoader implements ApplicationRunner {

    private final VehicleServiceImpl vehicleService;
    private final CsvService csvService;

    @Autowired
    public VehicleMotorcycleLoader(VehicleServiceImpl vehicleService, CsvService csvService) {
        this.vehicleService = vehicleService;
        this.csvService = csvService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("loading motorcycle to database");

        List<String[]> csvMotorcycle = csvService.readFile(FILE_PATH + "/motorcycles.csv");

        List<Vehicle> motorcycles = csvService.loadType(csvMotorcycle, new CsvToMotorcycle());
        motorcycles = vehicleService.registerAll(motorcycles);
    }
}
