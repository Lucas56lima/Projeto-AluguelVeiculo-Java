package com.aluguel.aluguelveiculo.domain.entities;

import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "tb_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "order_Id")
    private UUID orderId;

    @CreationTimestamp
    private Instant creationTimestamp;

    @Column(nullable = false)
    private double runValue; 

    @ManyToOne
    @JoinColumn(name = "deliveryman_Id")
    private Deliveryman deliveryman;

    @Column(nullable = false)
    private boolean availability = true;
    
    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Deliveryman getDeliveryman() {
        return deliveryman;
    }

    public void setDeliveryman(Deliveryman deliveryman) {
        this.deliveryman = deliveryman;
    }

    public double getRunValue() {
        return runValue;
    }

    public void setRunValue(double runValue) {
        this.runValue = runValue;
    }

    public Instant getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Instant creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

}
