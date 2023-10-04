package com.github.edsandrof.infnetjavaweb.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "vehicle_buyer")
public class VehicleBuyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phone;

    public VehicleBuyer() {
    }

    public VehicleBuyer(Long id) {
        this.id = id;
    }

    public VehicleBuyer(Long id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Long getId() {
        return id;
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
        return "Buyer name: " + name + ", address: " + address + ", phone: " + phone;
    }
}
