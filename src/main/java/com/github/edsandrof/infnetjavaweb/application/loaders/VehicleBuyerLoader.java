package com.github.edsandrof.infnetjavaweb.application.loaders;

import com.github.edsandrof.infnetjavaweb.model.domain.VehicleBuyer;
import com.github.edsandrof.infnetjavaweb.model.service.CsvService;
import com.github.edsandrof.infnetjavaweb.model.service.VehicleBuyerService;
import com.github.edsandrof.infnetjavaweb.model.service.impl.CsvToVehicleBuyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.github.edsandrof.infnetjavaweb.infrastructure.util.Constant.FILE_PATH;

@Order(4)
@Component
public class VehicleBuyerLoader implements ApplicationRunner {

    private final VehicleBuyerService vehicleBuyerService;
    private final CsvService csvService;

    @Autowired
    public VehicleBuyerLoader(VehicleBuyerService vehicleBuyerService, CsvService csvService) {
        this.vehicleBuyerService = vehicleBuyerService;
        this.csvService = csvService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("loading buyers to database");

        List<String[]> csvBuyers = csvService.readFile(FILE_PATH + "/buyers.csv");
        List<VehicleBuyer> vehicleBuyers = csvService.loadType(csvBuyers, new CsvToVehicleBuyer());

        vehicleBuyerService.registerAll(vehicleBuyers);
    }
}
