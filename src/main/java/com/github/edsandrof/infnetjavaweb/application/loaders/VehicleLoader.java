package com.github.edsandrof.infnetjavaweb.application.loaders;

import com.github.edsandrof.infnetjavaweb.model.domain.Vehicle;
import com.github.edsandrof.infnetjavaweb.model.domain.VehicleBuyer;
import com.github.edsandrof.infnetjavaweb.model.domain.VehicleDealer;
import com.github.edsandrof.infnetjavaweb.model.service.CsvService;
import com.github.edsandrof.infnetjavaweb.model.service.impl.CsvToCar;
import com.github.edsandrof.infnetjavaweb.model.service.impl.CsvToMotorcycle;
import com.github.edsandrof.infnetjavaweb.model.service.impl.CsvToTruck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.*;

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

    public static void main(String[] args) {
        List<String[]> csvCars = csvService.readFile(FILE_PATH + "/cars.csv");
        List<String[]> csvTrucks = csvService.readFile(FILE_PATH + "/trucks.csv");
        List<String[]> csvMotorcycle = csvService.readFile(FILE_PATH + "/motorcycles.csv");

        List<Vehicle> allVehicles = new ArrayList<>();
        allVehicles.addAll(csvService.loadVehicles(csvCars, new CsvToCar()));
        allVehicles.addAll(csvService.loadVehicles(csvTrucks, new CsvToTruck()));
        allVehicles.addAll(csvService.loadVehicles(csvMotorcycle, new CsvToMotorcycle()));

        List<Vehicle> vehiclesToBuy1 = Arrays.asList(
                allVehicles.get(0),
                allVehicles.get(2),
                allVehicles.get(5)
        );

        List<Vehicle> vehiclesToBuy2 = Arrays.asList(
                allVehicles.get(1),
                allVehicles.get(4),
                allVehicles.get(6)
        );

        // seller
        VehicleDealer vehicleDealer = new VehicleDealer("AllCars Vehicles", "Street park",
                new HashSet<>(allVehicles));

        // buyers
        VehicleBuyer fedexTransport = new VehicleBuyer("FedEx Transports", "1st Avenue");
        VehicleBuyer dhlLogistics = new VehicleBuyer("DHL Logistics", "Central park");

        // sales
        vehicleDealer.saleVehicles(fedexTransport, vehiclesToBuy1);
        vehicleDealer.saleVehicles(dhlLogistics, vehiclesToBuy2);

        vehicleDealer.generateReport(FILE_PATH + "report.html");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
