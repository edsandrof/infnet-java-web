package com.github.edsandrof.infnetjavaweb.model.domain;

import com.github.edsandrof.infnetjavaweb.model.enums.FuelType;
import com.github.edsandrof.infnetjavaweb.model.enums.MotorcycleCategory;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "motorcycle")
public class Motorcycle extends Vehicle {

    private boolean offRoad;
    private int cubicCapacity;

    @Enumerated(EnumType.STRING)
    private MotorcycleCategory category;

    public Motorcycle() {
    }

    public Motorcycle(Long id) {
        super(id);
    }

    public Motorcycle(Long id, String brand, int year, FuelType fuelType, double basePrice, double totalPrice,
                      boolean offRoad, int cubicCapacity, MotorcycleCategory category) {

        super(id, brand, year, fuelType, basePrice, totalPrice);
        this.offRoad = offRoad;
        this.cubicCapacity = cubicCapacity;
        this.category = category;
    }

    public boolean isOffRoad() {
        return offRoad;
    }

    public int getCubicCapacity() {
        return cubicCapacity;
    }

    public MotorcycleCategory getCategory() {
        return category;
    }

    public void setOffRoad(boolean offRoad) {
        this.offRoad = offRoad;
    }

    public void setCubicCapacity(int cubicCapacity) {
        this.cubicCapacity = cubicCapacity;
    }

    public void setCategory(MotorcycleCategory category) {
        this.category = category;
    }

    @Override
    public double getPrice() {
        double offRoadAdditional = 1000;
        double touringAdditional = 5000;
        double cubicCapacityAdditional = 2000;
        double total = super.getBasePrice();

        if (offRoad) {
            total += offRoadAdditional;
        }
        if (MotorcycleCategory.TOURING == category) {
            total += touringAdditional;
        }
        if (cubicCapacity > 175) {
            total += cubicCapacityAdditional;
        }

        return total;
    }

    @Override
    public String toString() {
        return "Motorcycle - offRoad: " + offRoad + ", " + cubicCapacity + "cc, category: " + category + super.toString();
    }
}
