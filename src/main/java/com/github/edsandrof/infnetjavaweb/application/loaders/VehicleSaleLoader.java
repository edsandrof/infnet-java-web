package com.github.edsandrof.infnetjavaweb.application.loaders;

import com.github.edsandrof.infnetjavaweb.model.domain.VehicleSale;
import com.github.edsandrof.infnetjavaweb.model.service.CsvService;
import com.github.edsandrof.infnetjavaweb.model.service.VehicleSaleService;
import com.github.edsandrof.infnetjavaweb.model.service.impl.CsvToVehicleSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.github.edsandrof.infnetjavaweb.infrastructure.util.Constant.FILE_PATH;

@Order(3)
@Component
public class VehicleSaleLoader implements ApplicationRunner {

    private final CsvService csvService;
    private final VehicleSaleService vehicleSaleService;

    @Autowired
    public VehicleSaleLoader(CsvService csvService, VehicleSaleService vehicleSaleService) {
        this.csvService = csvService;
        this.vehicleSaleService = vehicleSaleService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String[]> csvSales = csvService.readFile(FILE_PATH + "/sales.csv");
        List<VehicleSale> vehicleSales = csvService.loadType(csvSales, new CsvToVehicleSale());

        vehicleSaleService.registerAll(vehicleSales);
    }
}
