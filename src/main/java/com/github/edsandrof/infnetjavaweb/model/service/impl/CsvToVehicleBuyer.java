package com.github.edsandrof.infnetjavaweb.model.service.impl;

import com.github.edsandrof.infnetjavaweb.model.domain.VehicleBuyer;
import com.github.edsandrof.infnetjavaweb.model.service.CsvToType;

import java.util.ArrayList;
import java.util.List;

public class CsvToVehicleBuyer implements CsvToType<VehicleBuyer> {

    @Override
    public List<VehicleBuyer> convert(List<String[]> content) {
        List<VehicleBuyer> buyers = new ArrayList<>();

        for (String[] cols : content) {
            buyers.add(new VehicleBuyer(
                    Long.parseLong(cols[0]),
                    cols[1],
                    cols[2]
            ));
        }
        return buyers;
    }
}
