package com.github.edsandrof.infnetjavaweb.application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class VehicleSaleNotFoundException extends RuntimeException {

    public VehicleSaleNotFoundException(String message) {
        super(message);
    }
}
