package com.github.edsandrof.infnetjavaweb.model.domain;

import com.github.edsandrof.infnetjavaweb.model.enums.FuelType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "truck")
public class Truck extends Vehicle {

    @Column(name = "load_capacity")
    private int loadCapacity;

    @Column(name = "number_axle")
    private int numberOfAxle;

    public Truck() {
    }

    public Truck(Long id) {
        super(id);
    }

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

    @Override
    public String toString() {
        return "load capacity: " + loadCapacity + ", number of axle: " + numberOfAxle + ", " + super.toString();
    }
}
