package com.github.edsandrof.infnetjavaweb.model.domain;

import com.github.edsandrof.infnetjavaweb.model.enums.CarDoors;
import com.github.edsandrof.infnetjavaweb.model.enums.Color;
import com.github.edsandrof.infnetjavaweb.model.enums.FuelType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car extends Vehicle {

    @Enumerated(EnumType.STRING)
    private CarDoors numberOfDoors;

    @Enumerated(EnumType.STRING)
    private Color color;

    private boolean v8Engine;

    public Car() {
    }

    public Car(Long id) {
        super(id);
    }

    public Car(Long id, String brand, int year, FuelType fuelType, double basePrice, double totalPrice,
               CarDoors numberOfDoors, Color color, boolean v8Engine) {

        super(id, brand, year, fuelType, basePrice, totalPrice);
        this.numberOfDoors = numberOfDoors;
        this.color = color;
        this.v8Engine = v8Engine;
    }

    @Override
    public double getPrice() {
        double priceTwoDoors = 2000;
        double priceFourDoors = 5000;
        double colorAdditional = 1500;
        double engineAdditional = 10000;

        double total = super.getBasePrice();

        if (CarDoors.TWO_DOORS == numberOfDoors) {
            total += priceTwoDoors;
        } else if (CarDoors.FOUR_DOORS == numberOfDoors) {
            total += priceFourDoors;
        }

        if (color == Color.RED || color == Color.BLUE) {
            total += colorAdditional;
        }
        if (v8Engine) {
            total += engineAdditional;
        }

        return total;
    }

    @Override
    public String toString() {
        return "Car - doors: " + numberOfDoors + ", " + color + ", v8Engine: " + v8Engine + super.toString();
    }
}
