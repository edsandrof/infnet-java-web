package com.github.edsandrof.infnetjavaweb.model.domain;

public class VehicleBuyer {
    private String name;
    private String address;

    public VehicleBuyer(String name, String address) {
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

    @Override
    public String toString() {
        return "Buyer name: " + name + ", address: " + address;
    }
}