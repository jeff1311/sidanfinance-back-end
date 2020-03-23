package com.ljf.sidanfinance.dao.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "company")
public class Company {
    /**
     * ID
     */
    @Id
    private Integer id;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 项目名称
     */
    @Column(name = "group_name")
    private String groupName;

    /**
     * 插入时间
     */
    @Column(name = "date_insert")
    private Date dateInsert;

    public Company(Integer id, String name, String groupName, Date dateInsert) {
        this.id = id;
        this.name = name;
        this.groupName = groupName;
        this.dateInsert = dateInsert;
    }

    public Company() {
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
     * 获取公司名称
     *
     * @return name - 公司名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置公司名称
     *
     * @param name 公司名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取项目名称
     *
     * @return group_name - 项目名称
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置项目名称
     *
     * @param groupName 项目名称
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
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
}