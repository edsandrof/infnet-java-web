package com.github.edsandrof.infnetjavaweb.model.domain;

import com.github.edsandrof.infnetjavaweb.application.exceptions.UnavailableVehicleException;
import com.github.edsandrof.infnetjavaweb.model.service.ReportService;

import java.util.*;

public class VehicleDealer {
    private String name;
    private String address;
    private final VehicleSale[] sales;
    private final Set<Vehicle> availableVehicles;
    private final Set<Employee> employees;

    public VehicleDealer(String name, String address, Set<Vehicle> availableVehicles, Set<Employee> employees) {
        this.name = name;
        this.address = address;
        this.availableVehicles = availableVehicles;
        this.sales = new VehicleSale[100];
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public VehicleSale[] getSales() {
        return sales;
    }

    public Set<Vehicle> getAvailableVehicles() {
        return availableVehicles;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void saleVehicles(VehicleBuyer buyer, List<Vehicle> vehiclesToBuy) {
        checkVehicleAvailability(vehiclesToBuy);

        for (int i = 0; i < sales.length; i++) {
            if (sales[i] == null) {
                sales[i] = new VehicleSale(buyer, vehiclesToBuy);
                break;
            }
        }
        vehiclesToBuy.forEach(availableVehicles::remove);
    }

    @Deprecated
    public void generateReport(String path) {
        ReportService reportService = new ReportService();
        reportService.writeReport(path, name, sales);
    }

    private void checkVehicleAvailability(List<Vehicle> vehiclesToBuy) {
        for (Vehicle vehicle : vehiclesToBuy) {

            if (!availableVehicles.contains(vehicle)) {
                throw new UnavailableVehicleException("Vehicle " + vehicle + " is unavailable for sale.");
            }
        }
    }
}
