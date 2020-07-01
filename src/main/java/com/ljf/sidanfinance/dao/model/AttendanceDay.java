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
     * 工程ID
     */
    @Column(name = "project_id")
    private Integer projectId;

    /**
     * 工种
     */
    @Column(name = "work_type")
    private Integer workType;

    /**
     * 年
     */
    private String year;

    /**
     * 月
     */
    private String month;

    /**
     * 负责人
     */
    @Column(name = "responsible_person")
    private Integer responsiblePerson;

    @Column(name = "date_insert")
    private Date dateInsert;

    @Column(name = "date_update")
    private Date dateUpdate;

    @Column(name = "delete_mark")
    private Byte deleteMark;

    public AttendanceDay(Integer id, Integer projectId, Integer workType, String year, String month, Integer responsiblePerson, Date dateInsert, Date dateUpdate, Byte deleteMark) {
        this.id = id;
        this.projectId = projectId;
        this.workType = workType;
        this.year = year;
        this.month = month;
        this.responsiblePerson = responsiblePerson;
        this.dateInsert = dateInsert;
        this.dateUpdate = dateUpdate;
        this.deleteMark = deleteMark;
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
     * 获取工程ID
     *
     * @return project_id - 工程ID
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * 设置工程ID
     *
     * @param projectId 工程ID
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * 获取工种
     *
     * @return work_type - 工种
     */
    public Integer getWorkType() {
        return workType;
    }

    /**
     * 设置工种
     *
     * @param workType 工种
     */
    public void setWorkType(Integer workType) {
        this.workType = workType;
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
     * 获取负责人
     *
     * @return responsible_person - 负责人
     */
    public Integer getResponsiblePerson() {
        return responsiblePerson;
    }

    /**
     * 设置负责人
     *
     * @param responsiblePerson 负责人
     */
    public void setResponsiblePerson(Integer responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
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