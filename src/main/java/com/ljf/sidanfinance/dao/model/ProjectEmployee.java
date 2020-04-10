package com.ljf.sidanfinance.dao.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "project_employee")
public class ProjectEmployee {
    /**
     * ID
     */
    @Id
    private Integer id;

    /**
     * 项目ID
     */
    @Column(name = "project_id")
    private Integer projectId;

    /**
     * 员工ID
     */
    @Column(name = "employee_id")
    private Integer employeeId;

    /**
     * 插入时间
     */
    @Column(name = "date_insert")
    private Date dateInsert;

    /**
     * 删除标志
     */
    @Column(name = "delete_mark")
    private Integer deleteMark;

    public ProjectEmployee(Integer id, Integer projectId, Integer employeeId, Date dateInsert, Integer deleteMark) {
        this.id = id;
        this.projectId = projectId;
        this.employeeId = employeeId;
        this.dateInsert = dateInsert;
        this.deleteMark = deleteMark;
    }

    public ProjectEmployee() {
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