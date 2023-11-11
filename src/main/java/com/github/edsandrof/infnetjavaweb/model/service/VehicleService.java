package com.github.edsandrof.infnetjavaweb.model.service;

import java.util.List;

public interface VehicleService<T> {
    T find(Long id);

    T register(T vehicle);

    List<T> registerAll(List<T> vehicles);

    List<T> listAll();

    void delete(Long id);

    T update(T vehicle);
}
