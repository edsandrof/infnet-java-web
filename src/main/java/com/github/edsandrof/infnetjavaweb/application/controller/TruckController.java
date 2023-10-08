package com.github.edsandrof.infnetjavaweb.application.controller;

import com.github.edsandrof.infnetjavaweb.infrastructure.util.Constant.Page;
import com.github.edsandrof.infnetjavaweb.model.domain.Truck;
import com.github.edsandrof.infnetjavaweb.model.service.impl.TruckServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/vehicle/truck")
@Controller
public class TruckController {

    private final TruckServiceImpl truckService;

    @Autowired
    public TruckController(TruckServiceImpl truckService) {
        this.truckService = truckService;
    }

    @GetMapping
    public String getListPage(Model model) {
        model.addAttribute("trucks", truckService.listAll());
        return Page.VEHICLE_TRUCK_LIST;
    }

    @GetMapping(value = "/register")
    public String getRegisterPage() {
        return Page.VEHICLE_TRUCK_REGISTER;
    }

    @PostMapping(value = "/register")
    public String register(Truck truck) {
        truckService.register(truck);

        return Page.REDIRECT;
    }

    @GetMapping("/{id}")
    public String delete(@PathVariable Long id) {
        truckService.delete(id);

        return Page.REDIRECT + Page.VEHICLE_TRUCK_LIST;
    }
}
