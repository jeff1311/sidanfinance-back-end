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
     * 性别
     */
    private Byte gender;

    /**
     * 手机
     */
    private String phone;

    /**
     * 身份证号
     */
    @Column(name = "cert_no")
    private String certNo;

    /**
     * 银行卡号
     */
    @Column(name = "bank_no")
    private String bankNo;

    /**
     * 工长
     */
    @Column(name = "superior")
    private Integer superior;

    /**
     * 项目经理
     */
    private Integer manager;

    /**
     * 开户银行
     */
    @Column(name = "bank_name")
    private String bankName;

    /**
     * 工种 0=管理，1=木工，2=瓦工，3=油工，4=电工，5=小工，6=抹灰工
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

    public Employee(Integer id, String name, Byte gender, String phone, String certNo, String bankNo, Integer superior, Integer manager, String bankName, Integer type, Date dateInsert, Date dateUpdate, Integer deleteMark) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.certNo = certNo;
        this.bankNo = bankNo;
        this.superior = superior;
        this.manager = manager;
        this.bankName = bankName;
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
     * 获取性别
     *
     * @return gender - 性别
     */
    public Byte getGender() {
        return gender;
    }

    /**
     * 设置性别
     *
     * @param gender 性别
     */
    public void setGender(Byte gender) {
        this.gender = gender;
    }

    /**
     * 获取手机
     *
     * @return phone - 手机
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机
     *
     * @param phone 手机
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取身份证号
     *
     * @return cert_no - 身份证号
     */
    public String getCertNo() {
        return certNo;
    }

    /**
     * 设置身份证号
     *
     * @param certNo 身份证号
     */
    public void setCertNo(String certNo) {
        this.certNo = certNo == null ? null : certNo.trim();
    }

    /**
     * 获取银行卡号
     *
     * @return bank_no - 银行卡号
     */
    public String getBankNo() {
        return bankNo;
    }

    /**
     * 设置银行卡号
     *
     * @param bankNo 银行卡号
     */
    public void setBankNo(String bankNo) {
        this.bankNo = bankNo == null ? null : bankNo.trim();
    }

    /**
     * 获取工长
     *
     * @return superior_id - 工长
     */
    public Integer getSuperior() {
        return superior;
    }

    /**
     * 设置工长
     *
     * @param superior 工长
     */
    public void setSuperior(Integer superior) {
        this.superior = superior;
    }

    /**
     * 获取项目经理
     *
     * @return manager - 项目经理
     */
    public Integer getManager() {
        return manager;
    }

    /**
     * 设置项目经理
     *
     * @param manager 项目经理
     */
    public void setManager(Integer manager) {
        this.manager = manager;
    }

    /**
     * 获取开户银行
     *
     * @return bank_name - 开户银行
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置开户银行
     *
     * @param bankName 开户银行
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * 获取工种 0=管理，1=木工，2=瓦工，3=油工，4=电工，5=小工，6=抹灰工
     *
     * @return type - 工种 0=管理，1=木工，2=瓦工，3=油工，4=电工，5=小工，6=抹灰工
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置工种 0=管理，1=木工，2=瓦工，3=油工，4=电工，5=小工，6=抹灰工
     *
     * @param type 工种 0=管理，1=木工，2=瓦工，3=油工，4=电工，5=小工，6=抹灰工
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