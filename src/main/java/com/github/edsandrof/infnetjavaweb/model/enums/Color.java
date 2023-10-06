package com.github.edsandrof.infnetjavaweb.model.enums;

import com.github.edsandrof.infnetjavaweb.application.exceptions.InvalidEnumTypeException;

public enum Color {

    SILVER,
    RED,
    BLACK,
    WHITE,
    BLUE;

    public static Color safeValueOf(String value) {
        try {
            return Color.valueOf(value);

        } catch (IllegalArgumentException e) {
            throw new InvalidEnumTypeException("Error in value of Color enum: " + e.getMessage());
        }
    }
}
