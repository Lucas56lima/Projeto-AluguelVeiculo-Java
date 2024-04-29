package com.aluguel.aluguelveiculo.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "tb_deliveryman")
public class Deliveryman {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "deliverymanId")
    private UUID deliverymanId;

    @Column(unique = true, nullable = false)
    private String name;    

    @Column(unique = true, nullable = false)
    private String cnpj;
    
    @Column(nullable = false)
    private  Date birthday = new Date();
    

    @Column(unique = true, nullable = false)
    private String cnhNumber;
    

    @Column(unique = true,nullable = false)
    private String cnhType;

    @Column
    private boolean location = false;

    public boolean isLocation() {
        return location;
    }

    public void setLocation(boolean location) {
        this.location = location;
    }

    @CreationTimestamp
    private Instant CreationTimestamp;



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
