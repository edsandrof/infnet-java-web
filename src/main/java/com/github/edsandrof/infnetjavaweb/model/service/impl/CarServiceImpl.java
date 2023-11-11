package com.github.edsandrof.infnetjavaweb.model.service.impl;

import com.github.edsandrof.infnetjavaweb.application.exceptions.VehicleNotFoundException;
import com.github.edsandrof.infnetjavaweb.infrastructure.repository.CarRepository;
import com.github.edsandrof.infnetjavaweb.model.domain.Car;
import com.github.edsandrof.infnetjavaweb.model.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements VehicleService<Car> {
    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car find(Long id) {
        return carRepository.findById(id).orElseThrow(
                () -> new VehicleNotFoundException("Vehicle " + id + " was not found"));
    }

    @Override
    public Car register(Car vehicle) {
        return carRepository.save(vehicle);
    }

    @Override
    public List<Car> registerAll(List<Car> vehicles) {
        return carRepository.saveAll(vehicles);
    }

    @Override
    public List<Car> listAll() {
        return carRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Car vehicle = find(id);
        carRepository.delete(vehicle);
    }

    @Override
    public Car update(Car vehicle) {
        return carRepository.save(vehicle);
    }
}
