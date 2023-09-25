package com.github.edsandrof.infnetjavaweb.model.domain;

import java.time.LocalDateTime;
import java.util.List;

public class VehicleSale {
    private final LocalDateTime purchaseDate;
    private final VehicleBuyer vehicleBuyer;
    private final List<Vehicle> vehicles;
    private final double totalCost;

    public VehicleSale(VehicleBuyer vehicleBuyer, List<Vehicle> vehicles) {
        this.purchaseDate = LocalDateTime.now();
        this.vehicleBuyer = vehicleBuyer;
        this.vehicles = vehicles;
        this.totalCost = calculateTotalCost();
    }

    private double calculateTotalCost() {
        double sum = 0;

        for (Vehicle vehicle : vehicles) {
            sum += vehicle.getPrice();
        }
        return sum;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public VehicleBuyer getVehicleBuyer() {
        return vehicleBuyer;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return "Sale purchase date: " + purchaseDate +
                ", buyer: " + vehicleBuyer +
                ", vehicles: " + vehicles +
                ", total cost: " + totalCost;
    }
}
