package com.aluguel.aluguelveiculo.domain.commands;

import java.util.UUID;

import com.aluguel.aluguelveiculo.domain.entities.Deliveryman;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.time.LocalDate;


public class DeliverymanCommand {
   
    private UUID deliverymanId;
    
    @NotBlank
    private String name;   
    
    @NotBlank
    private String cnpj;    
    
    private  LocalDate birthday = LocalDate.now();   
    
    @NotBlank
    private String cnhNumber;   
    
    @NotBlank
    private String cnhType;

    @NotNull
    private boolean location = false;
    
    @NotBlank
    private String archiveName;

    private Instant CreationTimestamp;
    
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    
    public Deliveryman toEntity(){
        Deliveryman deliveryman = new Deliveryman();
        deliveryman.setName(this.name);
        deliveryman.setCnpj(this.cnpj);
        deliveryman.setCnhNumber(this.cnhNumber);
        deliveryman.setCnhType(this.cnhType);
        deliveryman.setBirthday(this.birthday);
        deliveryman.setEmail(this.email);
        deliveryman.setPassword(this.password);
        deliveryman.setArchiveName(this.archiveName);
        deliveryman.setLocation(this.location);        

        return deliveryman;
    }
    
}   
