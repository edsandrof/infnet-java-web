package main.java.edsandrof.infnetjavaoo.model.enums;

import main.java.edsandrof.infnetjavaoo.exceptions.InvalidEnumType;

public enum CarDoors {
    TWO_DOORS(2),
    FOUR_DOORS(4);

    private final int numberOfDoors;

    CarDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public static CarDoors safeValueOf(String value) {
        try {
            return CarDoors.valueOf(value);

        } catch (IllegalArgumentException e) {
            throw new InvalidEnumType("Error in value of CarDoors enum: " + e.getMessage());
        }
    }
}
