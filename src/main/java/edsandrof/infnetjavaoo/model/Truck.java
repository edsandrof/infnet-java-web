package main.java.edsandrof.infnetjavaoo.model;

import main.java.edsandrof.infnetjavaoo.model.enums.FuelType;

public class Truck extends Vehicle {
    private final int loadCapacity;
    private final int numberOfAxle;

    public Truck(Long id, String brand, int year, FuelType fuelType, double basePrice, int loadCapacity, int numberOfAxle) {
        super(id, brand, year, fuelType, basePrice);
        this.loadCapacity = loadCapacity;
        this.numberOfAxle = numberOfAxle;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public int getNumberOfAxle() {
        return numberOfAxle;
    }

    @Override
    public double getPrice() {
        double pricePerAxle = 4000;
        double totalAxle = numberOfAxle * pricePerAxle;

        return super.getBasePrice() + totalAxle;
    }
}
