package com.github.edsandrof.infnetjavaweb.model.service;

import com.github.edsandrof.infnetjavaweb.model.domain.Vehicle;

import java.util.List;

public interface CsvToType<T> {
    List<T> convert(List<String[]> content);
}
