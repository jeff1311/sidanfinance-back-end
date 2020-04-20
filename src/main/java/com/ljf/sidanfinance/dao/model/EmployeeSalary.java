package com.ljf.sidanfinance.dao.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "employee_salary")
public class EmployeeSalary {
    /**
     * ID
     */
    @Id
    private Integer id;

    /**
     * 员工ID
     */
    @Column(name = "employee_id")
    private Integer employeeId;

    /**
     * 项目ID
     */
    @Column(name = "project_id")
    private Integer projectId;

    /**
     * 工日
     */
    private Double day;

    /**
     * 工时
     */
    private Integer hour;

    /**
     * 工价
     */
    private Double price;

    /**
     * 奖金
     */
    private Double bonus;

    /**
     * 支款
     */
    private Double withdraw;

    /**
     * 应发工资
     */
    private Double amount;

    /**
     * 实发工资
     */
    @Column(name = "actual_amount")
    private Double actualAmount;

    /**
     * 年
     */
    private String year;

    /**
     * 月
     */
    private String month;

    /**
     * 插入时间
     */
    @Column(name = "date_insert")
    private Date dateInsert;

    /**
     * 更新时间
     */
    @Column(name = "date_update")
    private Date dateUpdate;

    /**
     * 删除标志
     */
    @Column(name = "delete_mark")
    private Integer deleteMark;

    public EmployeeSalary(Integer id, Integer employeeId, Integer projectId, Double day, Integer hour, Double price, Double bonus, Double withdraw, Double amount, Double actualAmount, String year, String month, Date dateInsert, Date dateUpdate, Integer deleteMark) {
        this.id = id;
        this.employeeId = employeeId;
        this.projectId = projectId;
        this.day = day;
        this.hour = hour;
        this.price = price;
        this.bonus = bonus;
        this.withdraw = withdraw;
        this.amount = amount;
        this.actualAmount = actualAmount;
        this.year = year;
        this.month = month;
        this.dateInsert = dateInsert;
        this.dateUpdate = dateUpdate;
        this.deleteMark = deleteMark;
    }

    public EmployeeSalary() {
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
     * 获取项目ID
     *
     * @return project_id - 项目ID
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * 设置项目ID
     *
     * @param projectId 项目ID
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
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
    public Integer getHour() {
        return hour;
    }

    /**
     * 设置工时
     *
     * @param hour 工时
     */
    public void setHour(Integer hour) {
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
     * 获取支款
     *
     * @return withdraw - 支款
     */
    public Double getWithdraw() {
        return withdraw;
    }

    /**
     * 设置支款
     *
     * @param withdraw 支款
     */
    public void setWithdraw(Double withdraw) {
        this.withdraw = withdraw;
    }

    /**
     * 获取应发工资
     *
     * @return amount - 应发工资
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * 设置应发工资
     *
     * @param amount 应发工资
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * 获取实发工资
     *
     * @return actual_amount - 实发工资
     */
    public Double getActualAmount() {
        return actualAmount;
    }

    /**
     * 设置实发工资
     *
     * @param actualAmount 实发工资
     */
    public void setActualAmount(Double actualAmount) {
        this.actualAmount = actualAmount;
    }

    /**
     * 获取年
     *
     * @return year - 年
     */
    public String getYear() {
        return year;
    }

    /**
     * 设置年
     *
     * @param year 年
     */
    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    /**
     * 获取月
     *
     * @return month - 月
     */
    public String getMonth() {
        return month;
    }

    /**
     * 设置月
     *
     * @param month 月
     */
    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    /**
     * 获取插入时间
     *
     * @return date_insert - 插入时间
     */
    public Date getDateInsert() {
        return dateInsert;
    }

    /**
     * 设置插入时间
     *
     * @param dateInsert 插入时间
     */
    public void setDateInsert(Date dateInsert) {
        this.dateInsert = dateInsert;
    }

    /**
     * 获取更新时间
     *
     * @return date_update - 更新时间
     */
    public Date getDateUpdate() {
        return dateUpdate;
    }

    /**
     * 设置更新时间
     *
     * @param dateUpdate 更新时间
     */
    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    /**
     * 获取删除标志
     *
     * @return delete_mark - 删除标志
     */
    public Integer getDeleteMark() {
        return deleteMark;
    }

    /**
     * 设置删除标志
     *
     * @param deleteMark 删除标志
     */
    public void setDeleteMark(Integer deleteMark) {
        this.deleteMark = deleteMark;
    }
}