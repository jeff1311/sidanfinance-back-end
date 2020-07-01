package com.ljf.sidanfinance.dao.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "attendance_day_detail")
public class AttendanceDayDetail {
    /**
     * ID
     */
    @Id
    private Integer id;

    /**
     * 考勤ID
     */
    @Column(name = "attendance_day_id")
    private Integer attendanceDayId;

    /**
     * 员工ID
     */
    @Column(name = "employee_id")
    private Integer employeeId;

    /**
     * 工日
     */
    private Double day;

    /**
     * 工时
     */
    private Double hour;

    /**
     * 工价
     */
    private Double price;

    /**
     * 工资
     */
    private Double amount;

    /**
     * 应付工资
     */
    @Column(name = "pay_amount")
    private Double payAmount;

    /**
     * 扣款
     */
    @Column(name = "deduct_amount")
    private Double deductAmount;

    /**
     * 奖金
     */
    private Double bonus;

    @Column(name = "date_insert")
    private Date dateInsert;

    @Column(name = "date_update")
    private Date dateUpdate;

    @Column(name = "delete_mark")
    private Byte deleteMark;

    public AttendanceDayDetail(Integer id, Integer attendanceDayId, Integer employeeId, Double day, Double hour, Double price, Double amount, Double payAmount, Double deductAmount, Double bonus, Date dateInsert, Date dateUpdate, Byte deleteMark) {
        this.id = id;
        this.attendanceDayId = attendanceDayId;
        this.employeeId = employeeId;
        this.day = day;
        this.hour = hour;
        this.price = price;
        this.amount = amount;
        this.payAmount = payAmount;
        this.deductAmount = deductAmount;
        this.bonus = bonus;
        this.dateInsert = dateInsert;
        this.dateUpdate = dateUpdate;
        this.deleteMark = deleteMark;
    }

    public AttendanceDayDetail() {
        super();
    }

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取考勤ID
     *
     * @return attendance_day_id - 考勤ID
     */
    public Integer getAttendanceDayId() {
        return attendanceDayId;
    }

    /**
     * 设置考勤ID
     *
     * @param attendanceDayId 考勤ID
     */
    public void setAttendanceDayId(Integer attendanceDayId) {
        this.attendanceDayId = attendanceDayId;
    }

    /**
     * 获取员工ID
     *
     * @return employee_id - 员工ID
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * 设置员工ID
     *
     * @param employeeId 员工ID
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * 获取工日
     *
     * @return day - 工日
     */
    public Double getDay() {
        return day;
    }

    /**
     * 设置工日
     *
     * @param day 工日
     */
    public void setDay(Double day) {
        this.day = day;
    }

    /**
     * 获取工时
     *
     * @return hour - 工时
     */
    public Double getHour() {
        return hour;
    }

    /**
     * 设置工时
     *
     * @param hour 工时
     */
    public void setHour(Double hour) {
        this.hour = hour;
    }

    /**
     * 获取工价
     *
     * @return price - 工价
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置工价
     *
     * @param price 工价
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取工资
     *
     * @return amount - 工资
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * 设置工资
     *
     * @param amount 工资
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * 获取应付工资
     *
     * @return pay_amount - 应付工资
     */
    public Double getPayAmount() {
        return payAmount;
    }

    /**
     * 设置应付工资
     *
     * @param payAmount 应付工资
     */
    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * 获取扣款
     *
     * @return deduct_amount - 扣款
     */
    public Double getDeductAmount() {
        return deductAmount;
    }

    /**
     * 设置扣款
     *
     * @param deductAmount 扣款
     */
    public void setDeductAmount(Double deductAmount) {
        this.deductAmount = deductAmount;
    }

    /**
     * 获取奖金
     *
     * @return bonus - 奖金
     */
    public Double getBonus() {
        return bonus;
    }

    /**
     * 设置奖金
     *
     * @param bonus 奖金
     */
    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    /**
     * @return date_insert
     */
    public Date getDateInsert() {
        return dateInsert;
    }

    /**
     * @param dateInsert
     */
    public void setDateInsert(Date dateInsert) {
        this.dateInsert = dateInsert;
    }

    /**
     * @return date_update
     */
    public Date getDateUpdate() {
        return dateUpdate;
    }

    /**
     * @param dateUpdate
     */
    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    /**
     * @return delete_mark
     */
    public Byte getDeleteMark() {
        return deleteMark;
    }

    /**
     * @param deleteMark
     */
    public void setDeleteMark(Byte deleteMark) {
        this.deleteMark = deleteMark;
    }
}