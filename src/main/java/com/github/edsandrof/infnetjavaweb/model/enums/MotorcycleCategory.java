package com.github.edsandrof.infnetjavaweb.model.enums;

import com.github.edsandrof.infnetjavaweb.application.exceptions.InvalidEnumTypeException;

public enum MotorcycleCategory {

    STANDARD,
    SCOOTER,
    SPORT,
    TOURING;

    public static MotorcycleCategory safeValueOf(String value) {
        try {
            return MotorcycleCategory.valueOf(value);

        } catch (IllegalArgumentException e) {
            throw new InvalidEnumTypeException("Error in value of MotorcycleCategory enum: " + e.getMessage());
        }
    }
}
