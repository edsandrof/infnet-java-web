package com.github.edsandrof.infnetjavaweb.application.controller;

import com.github.edsandrof.infnetjavaweb.infrastructure.util.Constant.Page;
import com.github.edsandrof.infnetjavaweb.model.domain.VehicleSale;
import com.github.edsandrof.infnetjavaweb.model.service.VehicleSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/vehiclesale")
@Controller
public class VehicleSaleController {

    private final VehicleSaleService vehicleSaleService;

    @Autowired
    public VehicleSaleController(VehicleSaleService vehicleSaleService) {
        this.vehicleSaleService = vehicleSaleService;
    }

    @GetMapping
    public String getListPage(Model model) {
        model.addAttribute("sales", vehicleSaleService.listAll());
        return Page.VEHICLE_SALE_LIST;
    }

    @GetMapping(value = "/register")
    public String getRegisterPage() {
        return Page.VEHICLE_SALE_REGISTER;
    }

    @PostMapping(value = "/register")
    public String register(VehicleSale vehicleSale) {
        vehicleSaleService.register(vehicleSale);

        return Page.REDIRECT;
    }

    @GetMapping("/{id}")
    public String delete(@PathVariable Long id) {
        vehicleSaleService.delete(id);

        return Page.REDIRECT + Page.VEHICLE_SALE;
    }
}
