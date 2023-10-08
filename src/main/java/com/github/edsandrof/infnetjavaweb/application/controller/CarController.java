package com.github.edsandrof.infnetjavaweb.application.controller;

import com.github.edsandrof.infnetjavaweb.infrastructure.util.Constant.Page;
import com.github.edsandrof.infnetjavaweb.model.domain.Car;
import com.github.edsandrof.infnetjavaweb.model.service.impl.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/vehicle/car")
@Controller
public class CarController {

    private final CarServiceImpl carService;

    @Autowired
    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping
    public String getListPage(Model model) {
        model.addAttribute("cars", carService.listAll());
        return Page.VEHICLE_CAR_LIST;
    }

    @GetMapping(value = "/register")
    public String getRegisterPage() {
        return Page.VEHICLE_CAR_REGISTER;
    }

    @PostMapping(value = "/register")
    public String register(Car car) {
        carService.register(car);

        return Page.REDIRECT;
    }

    @GetMapping("/{id}")
    public String delete(@PathVariable Long id) {
        carService.delete(id);

        return Page.REDIRECT + Page.VEHICLE_CAR_LIST;
    }
}
