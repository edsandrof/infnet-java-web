package com.github.edsandrof.infnetjavaweb.model.service;

import com.github.edsandrof.infnetjavaweb.application.exceptions.VehicleNotFoundException;
import com.github.edsandrof.infnetjavaweb.infrastructure.repository.VehicleRepository;
import com.github.edsandrof.infnetjavaweb.model.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle find(Long id) {
        return vehicleRepository.findById(id).orElseThrow(
                () -> new VehicleNotFoundException("Vehicle " + id + " was not found"));
    }

    public Vehicle register(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> listAll() {
        return vehicleRepository.findAll();
    }

    public void delete(Long id) {
        Vehicle vehicle = find(id);
        vehicleRepository.delete(vehicle);
    }
}
