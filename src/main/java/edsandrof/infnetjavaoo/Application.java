package main.java.edsandrof.infnetjavaoo;

import main.java.edsandrof.infnetjavaoo.model.Vehicle;
import main.java.edsandrof.infnetjavaoo.model.VehicleBuyer;
import main.java.edsandrof.infnetjavaoo.model.VehicleDealer;
import main.java.edsandrof.infnetjavaoo.service.CsvService;
import main.java.edsandrof.infnetjavaoo.service.CsvToCar;
import main.java.edsandrof.infnetjavaoo.service.CsvToMotorcycle;
import main.java.edsandrof.infnetjavaoo.service.CsvToTruck;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Application {

    public static void main(String[] args) {
        String path = "src/main/resources/";
        Locale.setDefault(Locale.US);

        CsvService csvService = new CsvService();
        List<String[]> csvCars = csvService.readFile(path + "cars.csv");
        List<Vehicle> cars = Vehicle.loadFromCsv(csvCars, new CsvToCar());

        List<String[]> csvTrucks = csvService.readFile(path + "trucks.csv");
        List<Vehicle> trucks = Vehicle.loadFromCsv(csvTrucks, new CsvToTruck());

        List<String[]> csvMotorcycle = csvService.readFile(path + "motorcycles.csv");
        List<Vehicle> motorcycles = Vehicle.loadFromCsv(csvMotorcycle, new CsvToMotorcycle());

        List<Vehicle> vehiclesToPurchase1 = Arrays.asList(
                cars.get(0),
                motorcycles.get(0),
                trucks.get(0)
        );

        List<Vehicle> vehiclesToPurchase2 = Arrays.asList(
                cars.get(1),
                motorcycles.get(1),
                trucks.get(1)
        );

        // seller
        VehicleDealer vehicleDealer = new VehicleDealer("AllCars Vehicles", "Street park");

        // buyers
        VehicleBuyer fedexTransport = new VehicleBuyer("FedEx Transports", "1st Avenue");
        VehicleBuyer dhlLogistics = new VehicleBuyer("DHL Logistics", "Central park");

        // sales
        vehicleDealer.saleVehicles(fedexTransport, vehiclesToPurchase1);
        vehicleDealer.saleVehicles(dhlLogistics, vehiclesToPurchase2);

        vehicleDealer.generateReport(path + "report.html");
    }
}
