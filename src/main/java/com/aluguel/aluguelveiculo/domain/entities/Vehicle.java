package com.aluguel.aluguelveiculo.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import java.time.Instant;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="tb_vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "vehicle_Id")
    private UUID vehicleId;

    @CreationTimestamp
    public Instant creationTimestamp;

    @Column(nullable = false)
    private String vehicleModel;

    @Column(unique = true,nullable = false)
    private String license; 
    
    @Column(nullable = false)
    private int year;

    /**
     * Join das tabelas DeliveryMan e Vehicle utilizando o deliveryman_id
     */
    @ManyToOne
    @JoinColumn(name = "deliveryman_Id")
    private Deliveryman deliveryman;    

    @Column(nullable = false)
    private boolean location = false;

    public boolean isLocation() {
        return location;
    }

    public void setLocation(boolean location) {
        this.location = location;
    }

    public Deliveryman getDeliveryman() {
        return deliveryman;
    }

    public void setDeliveryman(Deliveryman deliveryman) {
        this.deliveryman = deliveryman;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
