package com.github.edsandrof.infnetjavaweb.model.service.impl;

import com.github.edsandrof.infnetjavaweb.model.domain.VehicleBuyer;
import com.github.edsandrof.infnetjavaweb.model.service.CsvToType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CsvToVehicleBuyer implements CsvToType<VehicleBuyer> {

    @Override
    public List<VehicleBuyer> convert(List<String[]> content) {
        List<VehicleBuyer> buyers = new ArrayList<>();

        for (String[] cols : content) {
            buyers.add(new VehicleBuyer(
                    Long.parseLong(cols[0]),
                    cols[1],
                    cols[2],
                    cols[3]
            ));
        }
        return buyers;
    }
}
