package com.github.edsandrof.infnetjavaweb.application.loaders;

import com.github.edsandrof.infnetjavaweb.model.service.VehicleBuyerService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;

@Order
public class VehicleBuyersLoader implements ApplicationRunner {

    private final VehicleBuyerService vehicleBuyerService;

    public VehicleBuyersLoader(VehicleBuyerService vehicleBuyerService) {
        this.vehicleBuyerService = vehicleBuyerService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
