package com.github.edsandrof.infnetjavaweb.application.loaders;

import com.github.edsandrof.infnetjavaweb.model.domain.VehicleSale;
import com.github.edsandrof.infnetjavaweb.model.service.CsvService;
import com.github.edsandrof.infnetjavaweb.model.service.CsvToType;
import com.github.edsandrof.infnetjavaweb.model.service.VehicleSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.github.edsandrof.infnetjavaweb.infrastructure.util.Constant.FILE_PATH;

@Order(5)
@Component
public class VehicleSaleLoader implements ApplicationRunner {

    private final CsvService csvService;
    private final VehicleSaleService vehicleSaleService;
    private final CsvToType<VehicleSale> csvToVehicleSale;

    @Autowired
    public VehicleSaleLoader(CsvService csvService, VehicleSaleService vehicleSaleService, CsvToType<VehicleSale> csvToVehicleSale) {
        this.csvService = csvService;
        this.vehicleSaleService = vehicleSaleService;
        this.csvToVehicleSale = csvToVehicleSale;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("loading vehicles sales to database");

        List<String[]> csvSales = csvService.readFile(FILE_PATH + "/sales.csv");
        List<VehicleSale> vehicleSales = csvService.loadType(csvSales, csvToVehicleSale);

        vehicleSaleService.registerAll(vehicleSales);
    }
}
