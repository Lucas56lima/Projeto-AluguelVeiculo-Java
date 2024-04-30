package com.aluguel.aluguelveiculo.domain.model;

import java.sql.Date;

public class RentVehicleModel {
    private Date startDate;
    private int plan;
    private Date forecasDate;
    private Date returnDate;
    private Date dailyValue;
    private Date total;
    
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public int getPlan() {
        return plan;
    }
    public void setPlan(int plan) {
        this.plan = plan;
    }
    public Date getForecasDate() {
        return forecasDate;
    }
    public void setForecasDate(Date forecasDate) {
        this.forecasDate = forecasDate;
    }
    public Date getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    public Date getDailyValue() {
        return dailyValue;
    }
    public void setDailyValue(Date dailyValue) {
        this.dailyValue = dailyValue;
    }
    public Date getTotal() {
        return total;
    }
    public void setTotal(Date total) {
        this.total = total;
    }

}
