package com.github.edsandrof.infnetjavaweb.model.domain;

import com.github.edsandrof.infnetjavaweb.model.enums.FuelType;

public class Motorcycle extends Vehicle {
    private final boolean offRoad;

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
}
