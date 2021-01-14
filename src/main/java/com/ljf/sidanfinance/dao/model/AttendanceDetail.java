package com.ljf.sidanfinance.dao.model;

import java.util.Date;

public class AttendanceDetail {
	
    private Integer id;

    private Integer attId;
    
    private Integer empId;

    private Double day;

    private Double hour;

    private Double price;

    private Double amount;

    private Double payAmount;

    private Double deductAmount;

    private Double bonus;

    private Date dateInsert;

    private Date dateUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAttId() {
		return attId;
	}

	public void setAttId(Integer attId) {
		this.attId = attId;
	}

	public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Double getDay() {
        return day;
    }

    public void setDay(Double day) {
        this.day = day;
    }

    public Double getHour() {
        return hour;
    }

    public void setHour(Double hour) {
        this.hour = hour;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public Double getDeductAmount() {
        return deductAmount;
    }

    public void setDeductAmount(Double deductAmount) {
        this.deductAmount = deductAmount;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Date getDateInsert() {
        return dateInsert;
    }

    public void setDateInsert(Date dateInsert) {
        this.dateInsert = dateInsert;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
}