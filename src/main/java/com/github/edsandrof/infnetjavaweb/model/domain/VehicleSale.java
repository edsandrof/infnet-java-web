package com.github.edsandrof.infnetjavaweb.model.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "vehicle_sale")
public class VehicleSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime purchaseDate;

    @ManyToOne
    private VehicleBuyer vehicleBuyer;

    @OneToMany(cascade = {CascadeType.DETACH})
    private List<Vehicle> vehicles;

    private double totalCost;

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public VehicleSale(VehicleBuyer vehicleBuyer, List<Vehicle> vehicles) {
        this.purchaseDate = LocalDateTime.now();
        this.vehicleBuyer = vehicleBuyer;
        this.vehicles = vehicles;
        this.totalCost = calculateTotalCost();
    }

    public VehicleSale(Long id, VehicleBuyer vehicleBuyer, List<Vehicle> vehicles, double totalCost) {
        this(vehicleBuyer, vehicles);
        this.id = id;
        this.totalCost = totalCost;
    }

    public VehicleSale() {
    }

    private double calculateTotalCost() {
        double sum = 0;

        for (Vehicle vehicle : vehicles) {
            sum += vehicle.getPrice();
        }
        return sum;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public VehicleBuyer getVehicleBuyer() {
        return vehicleBuyer;
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
