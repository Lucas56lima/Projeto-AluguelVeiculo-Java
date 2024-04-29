package com.aluguel.aluguelveiculo.domain.commands;

import java.util.UUID;
import java.time.Instant;

public class VehicleCommand {
    
    private UUID vehicleId;
   
    public Instant creationTimestamp;
    
    private String vehicleModel;
    
    private String license;    
    
    private int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public UUID getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(UUID vehicleId) {
        this.vehicleId = vehicleId;
    }

}
