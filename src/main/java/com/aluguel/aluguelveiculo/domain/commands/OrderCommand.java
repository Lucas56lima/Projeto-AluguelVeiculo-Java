package com.aluguel.aluguelveiculo.domain.commands;

import java.time.Instant;
import java.util.UUID;


public class OrderCommand {
    
    private UUID orderId;
    
    private Instant creationTimestamp;
    
    private double runValue;   
    

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
