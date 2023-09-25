package com.github.edsandrof.infnetjavaweb.model.service;

import com.github.edsandrof.infnetjavaweb.application.exceptions.FileException;
import com.github.edsandrof.infnetjavaweb.model.domain.Vehicle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CsvService {
    public List<String[]> readFile(String path) {
        List<String[]> fileContent = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            String header = br.readLine(); // discard header

            while ((line = br.readLine()) != null) {
                fileContent.add(line.trim().split(","));
            }

        } catch (IOException e) {
            throw new FileException("Error in file reader: " + e.getMessage());
        }

        return fileContent;
    }

    public List<Vehicle> loadVehicles(List<String[]> content, CsvToVehicle csvToVehicle) {
        return csvToVehicle.convert(content);
    }
}
