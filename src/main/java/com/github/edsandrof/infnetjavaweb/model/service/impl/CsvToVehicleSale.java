package com.github.edsandrof.infnetjavaweb.model.service.impl;

import com.github.edsandrof.infnetjavaweb.model.domain.*;
import com.github.edsandrof.infnetjavaweb.model.enums.VehicleType;
import com.github.edsandrof.infnetjavaweb.model.service.CsvToType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.github.edsandrof.infnetjavaweb.model.enums.VehicleType.*;

@Service
public class CsvToVehicleSale implements CsvToType<VehicleSale> {

    @Override
    public List<VehicleSale> convert(List<String[]> content) {
        List<VehicleSale> vehicleSales = new ArrayList<>();

        for (String[] cols : content) {
            List<Vehicle> vehicles = new ArrayList<>();
            String[] ids = cols[2].split("\\|");

            for (String typeAndId : ids) {
                vehicles.add(vehicleFromId(typeAndId));
            }

            VehicleSale sale = new VehicleSale(
                    Long.parseLong(cols[0]),
                    new VehicleBuyer(Long.parseLong(cols[1])),
                    vehicles,
                    Double.parseDouble(cols[3]));

            vehicleSales.add(sale);
        }
        return vehicleSales;
    }

    private Vehicle vehicleFromId(String typeAndId) {
        char typeChar = typeAndId.charAt(0);
        VehicleType type = VehicleType.from(typeChar);

        long id = Long.parseLong(typeAndId.substring(1));

        Vehicle vehicle = null;
        if (type == CAR) {
            vehicle = new Car(id);
        } else if (type == MOTORCYCLE) {
            vehicle = new Motorcycle(id);
        } else if (type == TRUCK){
            vehicle = new Truck(id);
        }
        return vehicle;
    }
}
