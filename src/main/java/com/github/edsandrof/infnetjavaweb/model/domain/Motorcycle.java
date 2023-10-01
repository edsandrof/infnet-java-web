package com.github.edsandrof.infnetjavaweb.model.domain;

import com.github.edsandrof.infnetjavaweb.model.enums.FuelType;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "motorcycle")
public class Motorcycle extends Vehicle {
    private boolean offRoad;

    public Motorcycle() {
    }

    public Motorcycle(Long id, String brand, int year, FuelType fuelType, double basePrice, boolean offRoad) {
        super(id, brand, year, fuelType, basePrice);
        this.offRoad = offRoad;
    }

    public boolean isOffRoad() {
        return offRoad;
    }

    @Override
    public double getPrice() {
        double offRoadAdditional = 3000;
        double total = super.getBasePrice();

        if (offRoad) {
            total += offRoadAdditional;
        }

        return total;
    }

    @Override
    public String toString() {
        return "offroad: " + offRoad + ", " + super.toString();
    }
}
