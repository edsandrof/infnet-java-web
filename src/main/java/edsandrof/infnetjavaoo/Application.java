package main.java.edsandrof.infnetjavaoo;

import com.github.edsandrof.infnetjavaweb.model.domain.Vehicle;
import com.github.edsandrof.infnetjavaweb.model.domain.VehicleBuyer;
import com.github.edsandrof.infnetjavaweb.model.domain.VehicleDealer;
import com.github.edsandrof.infnetjavaweb.model.service.CsvService;
import com.github.edsandrof.infnetjavaweb.model.service.impl.CsvToCar;
import com.github.edsandrof.infnetjavaweb.model.service.impl.CsvToMotorcycle;
import com.github.edsandrof.infnetjavaweb.model.service.impl.CsvToTruck;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        String path = "src/main/resources/";
        Locale.setDefault(Locale.US);

        CsvService csvService = new CsvService();
        List<String[]> csvCars = csvService.readFile(path + "cars.csv");
        List<String[]> csvTrucks = csvService.readFile(path + "trucks.csv");
        List<String[]> csvMotorcycle = csvService.readFile(path + "motorcycles.csv");

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

        vehicleDealer.generateReport(path + "report.html");
    }
}
