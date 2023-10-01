package com.github.edsandrof.infnetjavaweb.application.loaders;

import com.github.edsandrof.infnetjavaweb.model.domain.Vehicle;
import com.github.edsandrof.infnetjavaweb.model.domain.VehicleBuyer;
import com.github.edsandrof.infnetjavaweb.model.domain.VehicleDealer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Order(3)
@Component
public class VehicleSaleLoader implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
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
    }
}
