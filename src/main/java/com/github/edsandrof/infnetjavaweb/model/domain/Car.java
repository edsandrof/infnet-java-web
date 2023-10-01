package com.github.edsandrof.infnetjavaweb.model.domain;

import com.github.edsandrof.infnetjavaweb.model.enums.CarDoors;
import com.github.edsandrof.infnetjavaweb.model.enums.FuelType;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car extends Vehicle {

    private CarDoors numberOfDoors;

    public Car() {
    }

    public Car(Long id) {
        super(id);
    }

    public Car(Long id, String brand, int year, FuelType fuelType, double basePrice, CarDoors numberOfDoors) {
        super(id, brand, year, fuelType, basePrice);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public double getPrice() {
        double priceTwoDoors = 2000;
        double priceFourDoors = 5000;

        double total = super.getBasePrice();

        if (numberOfDoors.equals(CarDoors.TWO_DOORS)) {
            total += priceTwoDoors;
        } else {
            total += priceFourDoors;
        }

        return total;
    }

    @Override
    public String toString() {
        return "numberOfDoors: " + numberOfDoors + ", " + super.toString();
    }
}
