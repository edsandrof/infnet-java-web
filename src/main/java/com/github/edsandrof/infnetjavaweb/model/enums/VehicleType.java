package com.github.edsandrof.infnetjavaweb.model.enums;

import com.github.edsandrof.infnetjavaweb.application.exceptions.InvalidVehicleTypeException;

public enum VehicleType {
    CAR('C'),
    MOTORCYCLE('M'),
    TRUCK('T');

    private final char type;

    VehicleType(char type) {
        this.type = type;
    }

    public char getType() {
        return type;
    }

    public static VehicleType from(char type) {
        for (VehicleType vehicleType : VehicleType.values()) {
            if (vehicleType.type == type) {
                return vehicleType;
            }
        }
        throw new InvalidVehicleTypeException("Invalid vehicle type: " + type);
    }
}
