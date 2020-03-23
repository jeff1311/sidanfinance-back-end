package com.ljf.sidanfinance.dao.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "employee")
public class Employee {
    /**
     * ID
     */
    @Id
    private Integer id;

    /**
     * 员工名称
     */
    private String name;

    /**
     * 工种
     */
    private Integer type;

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
     * 删除标记
     */
    @Column(name = "delete_mark")
    private Integer deleteMark;

    public Employee(Integer id, String name, Integer type, Date dateInsert, Date dateUpdate, Integer deleteMark) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.dateInsert = dateInsert;
        this.dateUpdate = dateUpdate;
        this.deleteMark = deleteMark;
    }

    public Employee() {
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
     * 获取员工名称
     *
     * @return name - 员工名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置员工名称
     *
     * @param name 员工名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取工种
     *
     * @return type - 工种
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置工种
     *
     * @param type 工种
     */
    public void setType(Integer type) {
        this.type = type;
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
     * 获取删除标记
     *
     * @return delete_mark - 删除标记
     */
    public Integer getDeleteMark() {
        return deleteMark;
    }

    /**
     * 设置删除标记
     *
     * @param deleteMark 删除标记
     */
    public void setDeleteMark(Integer deleteMark) {
        this.deleteMark = deleteMark;
    }
}