package com.ljf.sidanfinance.dao.model;

import java.util.Date;
import javax.persistence.*;

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
     * 合同甲方名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 合同甲方集团名称
     */
    @Column(name = "group_name")
    private String groupName;

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
    private Integer months;

    /**
     * 合同总价
     */
    @Column(name = "total_price")
    private Double totalPrice;

    /**
     * 项目经理
     */
    private Integer manager;

    /**
     * 区域总
     */
    @Column(name = "general_manager")
    private Integer generalManager;

    /**
     * 所在省
     */
    private String province;

    /**
     * 所在市
     */
    private String city;

    /**
     * 状态 1=待进场、2=施工中 、3=已完成
     */
    private Byte status;

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

    public Project(Integer id, String name, String no, String contractNo, String companyName, String groupName, Date contractSignDate, Date startDate, Date endDate, Integer months, Double totalPrice, Integer manager, Integer generalManager, String province, String city, Byte status, Date dateInsert, Date dateUpdate, Integer deleteMark) {
        this.id = id;
        this.name = name;
        this.no = no;
        this.contractNo = contractNo;
        this.companyName = companyName;
        this.groupName = groupName;
        this.contractSignDate = contractSignDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.months = months;
        this.totalPrice = totalPrice;
        this.manager = manager;
        this.generalManager = generalManager;
        this.province = province;
        this.city = city;
        this.status = status;
        this.dateInsert = dateInsert;
        this.dateUpdate = dateUpdate;
        this.deleteMark = deleteMark;
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
     * 获取合同甲方名称
     *
     * @return company_name - 合同甲方名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置合同甲方名称
     *
     * @param companyName 合同甲方名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * 获取合同甲方集团名称
     *
     * @return group_name - 合同甲方集团名称
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置合同甲方集团名称
     *
     * @param groupName 合同甲方集团名称
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
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
    public Integer getMonths() {
        return months;
    }

    /**
     * 设置月数（历时）
     *
     * @param months 月数（历时）
     */
    public void setMonths(Integer months) {
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
     * 获取区域总
     *
     * @return general_manager - 区域总
     */
    public Integer getGeneralManager() {
        return generalManager;
    }

    /**
     * 设置区域总
     *
     * @param generalManager 区域总
     */
    public void setGeneralManager(Integer generalManager) {
        this.generalManager = generalManager;
    }

    /**
     * 获取所在省
     *
     * @return province - 所在省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置所在省
     *
     * @param province 所在省
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 获取所在市
     *
     * @return city - 所在市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置所在市
     *
     * @param city 所在市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 获取状态 1=待进场、2=施工中 、3=已完成
     *
     * @return status - 状态 1=待进场、2=施工中 、3=已完成
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态 1=待进场、2=施工中 、3=已完成
     *
     * @param status 状态 1=待进场、2=施工中 、3=已完成
     */
    public void setStatus(Byte status) {
        this.status = status;
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