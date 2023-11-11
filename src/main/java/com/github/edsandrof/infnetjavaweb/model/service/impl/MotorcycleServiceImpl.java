package com.github.edsandrof.infnetjavaweb.model.service.impl;

import com.github.edsandrof.infnetjavaweb.application.exceptions.VehicleNotFoundException;
import com.github.edsandrof.infnetjavaweb.infrastructure.repository.MotorcycleRepository;
import com.github.edsandrof.infnetjavaweb.model.domain.Motorcycle;
import com.github.edsandrof.infnetjavaweb.model.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorcycleServiceImpl implements VehicleService<Motorcycle> {
    private final MotorcycleRepository motorcycleRepository;

    @Autowired
    public MotorcycleServiceImpl(MotorcycleRepository motorcycleRepository) {
        this.motorcycleRepository = motorcycleRepository;
    }

    @Override
    public Motorcycle find(Long id) {
        return motorcycleRepository.findById(id).orElseThrow(
                () -> new VehicleNotFoundException("Vehicle " + id + " was not found"));
    }

    @Override
    public Motorcycle register(Motorcycle vehicle) {
        return motorcycleRepository.save(vehicle);
    }

    @Override
    public List<Motorcycle> registerAll(List<Motorcycle> vehicles) {
        return motorcycleRepository.saveAll(vehicles);
    }

    @Override
    public List<Motorcycle> listAll() {
        return motorcycleRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Motorcycle vehicle = find(id);
        motorcycleRepository.delete(vehicle);
    }

    @Override
    public Motorcycle update(Motorcycle vehicle) {
        return motorcycleRepository.save(vehicle);
    }
}
