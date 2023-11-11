package com.github.edsandrof.infnetjavaweb.model.service.impl;

import com.github.edsandrof.infnetjavaweb.application.exceptions.VehicleNotFoundException;
import com.github.edsandrof.infnetjavaweb.infrastructure.repository.VehicleRepository;
import com.github.edsandrof.infnetjavaweb.model.domain.Vehicle;
import com.github.edsandrof.infnetjavaweb.model.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService<Vehicle> {
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle find(Long id) {
        return vehicleRepository.findById(id).orElseThrow(
                () -> new VehicleNotFoundException("Vehicle " + id + " was not found"));
    }

    @Override
    public Vehicle register(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> registerAll(List<Vehicle> vehicles) {
        return vehicleRepository.saveAll(vehicles);
    }

    @Override
    public List<Vehicle> listAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Vehicle vehicle = find(id);
        vehicleRepository.delete(vehicle);
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
}
