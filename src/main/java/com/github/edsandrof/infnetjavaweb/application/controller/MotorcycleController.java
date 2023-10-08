package com.github.edsandrof.infnetjavaweb.application.controller;

import com.github.edsandrof.infnetjavaweb.infrastructure.util.Constant.Page;
import com.github.edsandrof.infnetjavaweb.model.domain.Motorcycle;
import com.github.edsandrof.infnetjavaweb.model.service.impl.MotorcycleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/vehicle/motorcycle")
@Controller
public class MotorcycleController {

    private final MotorcycleServiceImpl motorcycleService;

    @Autowired
    public MotorcycleController(MotorcycleServiceImpl motorcycleService) {
        this.motorcycleService = motorcycleService;
    }

    @GetMapping
    public String getListPage(Model model) {
        model.addAttribute("motorcycles", motorcycleService.listAll());
        return Page.VEHICLE_MOTORCYCLE_LIST;
    }

    @GetMapping(value = "/register")
    public String getRegisterPage() {
        return Page.VEHICLE_MOTORCYCLE_REGISTER;
    }

    @PostMapping(value = "/register")
    public String register(Motorcycle motorcycle) {
        motorcycleService.register(motorcycle);

        return Page.REDIRECT;
    }

    @GetMapping("/{id}")
    public String delete(@PathVariable Long id) {
        motorcycleService.delete(id);

        return Page.REDIRECT + Page.VEHICLE_MOTORCYCLE;
    }
}
