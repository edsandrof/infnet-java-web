package main.java.edsandrof.infnetjavaoo.model;

import main.java.edsandrof.infnetjavaoo.model.enums.FuelType;

public abstract class Vehicle {
    private final Long id;
    private final String brand;
    private final int year;
    private final FuelType fuelType;
    private double basePrice;

    public Vehicle(Long id, String brand, int year, FuelType fuelType, double basePrice) {
        this.id = id;
        this.brand = brand;
        this.year = year;
        this.fuelType = fuelType;
        this.basePrice = basePrice;
    }

    public void accelarate() {
        System.out.println("This vehicle is accelerating...");
    }

    public void brake() {
        System.out.println("This vehicle is braking...");
    }

    public abstract double getPrice();

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public String toString() {
        return "Vehicle brand: " + brand + ", year: " + year +", fuel type: " + fuelType;
    }
}
