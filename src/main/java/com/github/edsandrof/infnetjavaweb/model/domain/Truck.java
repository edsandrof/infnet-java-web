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

    @Column(name = "has_cargo_body")
    private boolean hasCargoBody;

    public Truck() {
    }

    public Truck(Long id) {
        super(id);
    }

    public Truck(Long id, String brand, int year, FuelType fuelType, double basePrice, double totalPrice,
                 int loadCapacity, int numberOfAxle, boolean hasCargoBody) {

        super(id, brand, year, fuelType, basePrice, totalPrice);
        this.loadCapacity = loadCapacity;
        this.numberOfAxle = numberOfAxle;
        this.hasCargoBody = hasCargoBody;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public int getNumberOfAxle() {
        return numberOfAxle;
    }

    public boolean isHasCargoBody() {
        return hasCargoBody;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public void setNumberOfAxle(int numberOfAxle) {
        this.numberOfAxle = numberOfAxle;
    }

    public void setHasCargoBody(boolean hasCargoBody) {
        this.hasCargoBody = hasCargoBody;
    }

    @Override
    public double getPrice() {
        double pricePerAxle = 4000;
        double cargoBodyAdditional = 10000;
        double totalAxle = numberOfAxle * pricePerAxle;

        double total = super.getBasePrice();
        total += totalAxle;

        if (hasCargoBody) {
            total += cargoBodyAdditional;
        }

        return total;
    }

    @Override
    public String toString() {
        return "load capacity: " + loadCapacity + ", number of axle: " + numberOfAxle + ", has cargo body: " + hasCargoBody + super.toString();
    }
}
