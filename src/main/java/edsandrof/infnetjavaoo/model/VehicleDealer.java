package main.java.edsandrof.infnetjavaoo.model;

import main.java.edsandrof.infnetjavaoo.service.ReportService;

import java.util.*;

public class VehicleDealer {
    private String name;
    private String address;
    private final Set<VehicleSale> sales = new HashSet<>();

    public VehicleDealer(String name, String address) {
        this.name = name;
        this.address = address;
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

    public Set<VehicleSale> getSales() {
        return sales;
    }

    public void saleVehicles(VehicleBuyer buyer, List<Vehicle> vehicles) {
        sales.add(new VehicleSale(buyer, vehicles));
    }

    public void generateReport(String path) {
        ReportService reportService = new ReportService();
        reportService.writeReport(path, name, sales);
    }
}
