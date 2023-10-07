package com.github.edsandrof.infnetjavaweb.application.controller;

import com.github.edsandrof.infnetjavaweb.infrastructure.util.Constant.Page;
import com.github.edsandrof.infnetjavaweb.model.domain.VehicleBuyer;
import com.github.edsandrof.infnetjavaweb.model.service.VehicleBuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/vehiclebuyer")
@Controller
public class VehicleBuyerController {

    private final VehicleBuyerService vehicleBuyerService;

    @Autowired
    public VehicleBuyerController(VehicleBuyerService vehicleBuyerService) {
        this.vehicleBuyerService = vehicleBuyerService;
    }

    @GetMapping
    public String getListPage(Model model) {
        model.addAttribute("buyers", vehicleBuyerService.listAll());
        return Page.VEHICLE_BUYER_LIST;
    }

    @GetMapping(value = "/register")
    public String getRegisterPage() {
        return Page.VEHICLE_BUYER_REGISTER;
    }

    @PostMapping(value = "/register")
    public String register(VehicleBuyer vehicleBuyer) {
        vehicleBuyerService.register(vehicleBuyer);

        return Page.REDIRECT;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        vehicleBuyerService.delete(id);

        return Page.REDIRECT + Page.VEHICLE_BUYER_LIST;
    }
}
