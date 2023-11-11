package com.github.edsandrof.infnetjavaweb.model.service.impl;

import com.github.edsandrof.infnetjavaweb.application.exceptions.VehicleNotFoundException;
import com.github.edsandrof.infnetjavaweb.infrastructure.repository.TruckRepository;
import com.github.edsandrof.infnetjavaweb.model.domain.Truck;
import com.github.edsandrof.infnetjavaweb.model.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TruckServiceImpl implements VehicleService<Truck> {
    private final TruckRepository truckRepository;

    @Autowired
    public TruckServiceImpl(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    @Override
    public Truck find(Long id) {
        return truckRepository.findById(id).orElseThrow(
                () -> new VehicleNotFoundException("Vehicle " + id + " was not found"));
    }

    @Override
    public Truck register(Truck vehicle) {
        return truckRepository.save(vehicle);
    }

    @Override
    public List<Truck> registerAll(List<Truck> vehicles) {
        return truckRepository.saveAll(vehicles);
    }

    @Override
    public List<Truck> listAll() {
        return truckRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Truck vehicle = find(id);
        truckRepository.delete(vehicle);
    }

    @Override
    public Truck update(Truck vehicle) {
        return truckRepository.save(vehicle);
    }
}
