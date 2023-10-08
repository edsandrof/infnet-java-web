package com.github.edsandrof.infnetjavaweb.model.domain;

import com.github.edsandrof.infnetjavaweb.model.enums.FuelType;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private int year;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @Column(name = "base_price")
    private double basePrice;

    @Column(name = "total_price")
    private double totalPrice;

    public Vehicle() {
    }

    public Vehicle(Long id) {
        this.id = id;
    }

    public Vehicle(Long id, String brand, int year, FuelType fuelType, double basePrice, double totalPrice) {
        this.id = id;
        this.brand = brand;
        this.year = year;
        this.fuelType = fuelType;
        this.basePrice = basePrice;
        this.totalPrice = totalPrice;
    }

    public Vehicle(String brand, int year, FuelType fuelType, double basePrice, double totalPrice) {
        this.brand = brand;
        this.year = year;
        this.fuelType = fuelType;
        this.basePrice = basePrice;
        this.totalPrice = totalPrice;
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

    public double getTotalPrice() {
        return getPrice();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return ", brand: " + brand + ", year: " + year + ", fuel type: " + fuelType + ", base price: " + basePrice + ", total price: " + totalPrice;
    }
}
