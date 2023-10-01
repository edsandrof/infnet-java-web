package com.github.edsandrof.infnetjavaweb.model.service;

import com.github.edsandrof.infnetjavaweb.application.exceptions.VehicleNotFoundException;
import com.github.edsandrof.infnetjavaweb.application.exceptions.VehicleSaleNotFoundException;
import com.github.edsandrof.infnetjavaweb.infrastructure.repository.VehicleSaleRepository;
import com.github.edsandrof.infnetjavaweb.model.domain.Vehicle;
import com.github.edsandrof.infnetjavaweb.model.domain.VehicleSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleSaleService {

    private final VehicleSaleRepository vehicleSaleRepository;

    @Autowired
    public VehicleSaleService(VehicleSaleRepository vehicleSaleRepository) {
        this.vehicleSaleRepository = vehicleSaleRepository;
    }

    public VehicleSale find(Long id) {
        return vehicleSaleRepository.findById(id).orElseThrow(
                () -> new VehicleSaleNotFoundException("Vehicle sale " + id + " was not found"));
    }

    public VehicleSale register(VehicleSale vehicleSale) {
        return vehicleSaleRepository.save(vehicleSale);
    }

    public List<VehicleSale> listAll() {
        return vehicleSaleRepository.findAll();
    }

    public void delete(Long id) {
        VehicleSale vehicleSale = find(id);
        vehicleSaleRepository.delete(vehicleSale);
    }
}
