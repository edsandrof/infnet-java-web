package com.github.edsandrof.infnetjavaweb.application.controller;

import com.github.edsandrof.infnetjavaweb.infrastructure.util.Constant.Page;
import com.github.edsandrof.infnetjavaweb.model.domain.Car;
import com.github.edsandrof.infnetjavaweb.model.service.impl.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/vehicle")
@Controller
public class VehicleController {

    private final VehicleServiceImpl vehicleService;

    @Autowired
    public VehicleController(VehicleServiceImpl vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public String getListPage(Model model) {
        model.addAttribute("vehicles", vehicleService.listAll());
        return Page.VEHICLE_LIST;
    }

    @GetMapping(value = "/register")
    public String getRegisterPage() {
        return Page.VEHICLE_REGISTER;
    }

    @PostMapping(value = "/register")
    public String register(Car car) {
        vehicleService.register(car);

        return Page.REDIRECT;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        vehicleService.delete(id);

        return Page.REDIRECT + Page.VEHICLE_LIST;
    }
}
