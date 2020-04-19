package com.ljf.sidanfinance.dao.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "attendance_day")
public class AttendanceDay {
    /**
     * ID
     */
    @Id
    private Integer id;

    /**
     * 雇员ID
     */
    @Column(name = "employee_id")
    private Integer employeeId;

    /**
     * 项目ID
     */
    @Column(name = "project_id")
    private Integer projectId;

    /**
     * 上午（是否出席）
     */
    private Boolean forenoon;

    /**
     * 下午（是否出席）
     */
    private Boolean afternoon;

    /**
     * 小时
     */
    private Byte hour;

    /**
     * 日期
     */
    private Date date;

    /**
     * 备注
     */
    private String remark;

    /**
     * 插入日期
     */
    @Column(name = "date_insert")
    private Date dateInsert;

    /**
     * 更新日期
     */
    @Column(name = "date_update")
    private Date dateUpdate;

    public AttendanceDay(Integer id, Integer employeeId, Integer projectId, Boolean forenoon, Boolean afternoon, Byte hour, Date date, String remark, Date dateInsert, Date dateUpdate) {
        this.id = id;
        this.employeeId = employeeId;
        this.projectId = projectId;
        this.forenoon = forenoon;
        this.afternoon = afternoon;
        this.hour = hour;
        this.date = date;
        this.remark = remark;
        this.dateInsert = dateInsert;
        this.dateUpdate = dateUpdate;
    }

    public AttendanceDay() {
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
     * 获取雇员ID
     *
     * @return employee_id - 雇员ID
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * 设置雇员ID
     *
     * @param employeeId 雇员ID
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
     * 获取上午（是否出席）
     *
     * @return forenoon - 上午（是否出席）
     */
    public Boolean getForenoon() {
        return forenoon;
    }

    /**
     * 设置上午（是否出席）
     *
     * @param forenoon 上午（是否出席）
     */
    public void setForenoon(Boolean forenoon) {
        this.forenoon = forenoon;
    }

    /**
     * 获取下午（是否出席）
     *
     * @return afternoon - 下午（是否出席）
     */
    public Boolean getAfternoon() {
        return afternoon;
    }

    /**
     * 设置下午（是否出席）
     *
     * @param afternoon 下午（是否出席）
     */
    public void setAfternoon(Boolean afternoon) {
        this.afternoon = afternoon;
    }

    /**
     * 获取小时
     *
     * @return hour - 小时
     */
    public Byte getHour() {
        return hour;
    }

    /**
     * 设置小时
     *
     * @param hour 小时
     */
    public void setHour(Byte hour) {
        this.hour = hour;
    }

    /**
     * 获取日期
     *
     * @return date - 日期
     */
    public Date getDate() {
        return date;
    }

    /**
     * 设置日期
     *
     * @param date 日期
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取插入日期
     *
     * @return date_insert - 插入日期
     */
    public Date getDateInsert() {
        return dateInsert;
    }

    /**
     * 设置插入日期
     *
     * @param dateInsert 插入日期
     */
    public void setDateInsert(Date dateInsert) {
        this.dateInsert = dateInsert;
    }

    /**
     * 获取更新日期
     *
     * @return date_update - 更新日期
     */
    public Date getDateUpdate() {
        return dateUpdate;
    }

    /**
     * 设置更新日期
     *
     * @param dateUpdate 更新日期
     */
    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
}