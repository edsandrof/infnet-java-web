package com.github.edsandrof.infnetjavaweb.model.service;

import com.github.edsandrof.infnetjavaweb.application.exceptions.VehicleNotFoundException;
import com.github.edsandrof.infnetjavaweb.infrastructure.repository.VehicleBuyerRepository;
import com.github.edsandrof.infnetjavaweb.model.domain.Vehicle;
import com.github.edsandrof.infnetjavaweb.model.domain.VehicleBuyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleBuyerService {
    private final VehicleBuyerRepository vehicleBuyerRepository;

    @Autowired
    public VehicleBuyerService(VehicleBuyerRepository vehicleBuyerRepository) {
        this.vehicleBuyerRepository = vehicleBuyerRepository;
    }

    public VehicleBuyer find(Long id) {
        return vehicleBuyerRepository.findById(id).orElseThrow(
                () -> new VehicleNotFoundException("Vehicle buyer " + id + " was not found"));
    }

    public VehicleBuyer register(VehicleBuyer vehicleBuyer) {
        return vehicleBuyerRepository.save(vehicleBuyer);
    }

    public List<VehicleBuyer> registerAll(List<VehicleBuyer> vehicleBuyers) {
        return vehicleBuyerRepository.saveAll(vehicleBuyers);
    }

    public List<VehicleBuyer> listAll() {
        return vehicleBuyerRepository.findAll();
    }

    public void delete(Long id) {
        VehicleBuyer vehicleBuyer = find(id);
        vehicleBuyerRepository.delete(vehicleBuyer);
    }
}
