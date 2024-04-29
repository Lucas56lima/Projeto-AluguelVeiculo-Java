package com.aluguel.aluguelveiculo.domain.commands;

import java.util.UUID;
import java.time.Instant;
import java.util.Date;

public class DeliverymanCommand {
   
    private UUID deliverymanId;
    
    private String name;   
    
    private String cnpj;    
    
    private  Date birthday = new Date();   
    
    private String cnhNumber;   
    
    private String cnhType;

    private boolean location = false;
    
    private String archiveName;

    private Instant CreationTimestamp;    

    public String getArchiveName() {
        return archiveName;
    }

    public void setArchiveName(String archiveName) {
        this.archiveName = archiveName;
    }

    public boolean isLocation() {
        return location;
    }

    public void setLocation(boolean location) {
        this.location = location;
    }    
    
    public Instant getCreationTimestamp() {
        return CreationTimestamp;
    }

    public void setCreationTimestamp(Instant creationTimestamp) {
        CreationTimestamp = creationTimestamp;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnhNumber() {
        return cnhNumber;
    }

    public void setCnhNumber(String cnhNumber) {
        this.cnhNumber = cnhNumber;
    }

    public String getCnhType() {
        return cnhType;
    }

    public void setCnhType(String cnhType) {
        this.cnhType = cnhType;
    }    
    

    public UUID getDeliverymanId() {
        return deliverymanId;
    }

    public void setDeliverymanId(UUID deliverymanId) {
        this.deliverymanId = deliverymanId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }   
    
}   
