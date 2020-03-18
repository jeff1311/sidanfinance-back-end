package com.ljf.sidanfinance.dao.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "project")
public class Project {
    /**
     * ID
     */
    @Id
    private Integer id;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 项目编号
     */
    private String no;

    /**
     * 合同编号
     */
    @Column(name = "contract_no")
    private String contractNo;

    /**
     * 合同甲方ID
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 合同签订时间
     */
    @Column(name = "contract_sign_date")
    private Date contractSignDate;

    /**
     * 项目开工时间
     */
    @Column(name = "start_date")
    private Date startDate;

    /**
     * 项目竣工时间
     */
    @Column(name = "end_date")
    private Date endDate;

    /**
     * 月数（历时）
     */
    private Byte months;

    /**
     * 合同总价
     */
    @Column(name = "total_price")
    private Double totalPrice;

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

    public Project(Integer id, String name, String no, String contractNo, Integer companyId, Date contractSignDate, Date startDate, Date endDate, Byte months, Double totalPrice, Date dateInsert, Date dateUpdate) {
        this.id = id;
        this.name = name;
        this.no = no;
        this.contractNo = contractNo;
        this.companyId = companyId;
        this.contractSignDate = contractSignDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.months = months;
        this.totalPrice = totalPrice;
        this.dateInsert = dateInsert;
        this.dateUpdate = dateUpdate;
    }

    public Project() {
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
     * 获取项目名称
     *
     * @return name - 项目名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置项目名称
     *
     * @param name 项目名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取项目编号
     *
     * @return no - 项目编号
     */
    public String getNo() {
        return no;
    }

    /**
     * 设置项目编号
     *
     * @param no 项目编号
     */
    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    /**
     * 获取合同编号
     *
     * @return contract_no - 合同编号
     */
    public String getContractNo() {
        return contractNo;
    }

    /**
     * 设置合同编号
     *
     * @param contractNo 合同编号
     */
    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    /**
     * 获取合同甲方ID
     *
     * @return company_id - 合同甲方ID
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 设置合同甲方ID
     *
     * @param companyId 合同甲方ID
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取合同签订时间
     *
     * @return contract_sign_date - 合同签订时间
     */
    public Date getContractSignDate() {
        return contractSignDate;
    }

    /**
     * 设置合同签订时间
     *
     * @param contractSignDate 合同签订时间
     */
    public void setContractSignDate(Date contractSignDate) {
        this.contractSignDate = contractSignDate;
    }

    /**
     * 获取项目开工时间
     *
     * @return start_date - 项目开工时间
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 设置项目开工时间
     *
     * @param startDate 项目开工时间
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取项目竣工时间
     *
     * @return end_date - 项目竣工时间
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置项目竣工时间
     *
     * @param endDate 项目竣工时间
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取月数（历时）
     *
     * @return months - 月数（历时）
     */
    public Byte getMonths() {
        return months;
    }

    /**
     * 设置月数（历时）
     *
     * @param months 月数（历时）
     */
    public void setMonths(Byte months) {
        this.months = months;
    }

    /**
     * 获取合同总价
     *
     * @return total_price - 合同总价
     */
    public Double getTotalPrice() {
        return totalPrice;
    }

    /**
     * 设置合同总价
     *
     * @param totalPrice 合同总价
     */
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
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
}