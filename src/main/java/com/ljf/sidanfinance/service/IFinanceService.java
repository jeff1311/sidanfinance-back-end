package com.ljf.sidanfinance.service;

import com.alibaba.fastjson.JSONObject;

public interface IFinanceService {

    public abstract JSONObject getIndexData();

    public abstract JSONObject getProjectList(JSONObject params);

    public abstract JSONObject getProjectInfo(String projectId);

    public abstract JSONObject addProject(JSONObject params);

    public abstract JSONObject getCompanyList(JSONObject params);

    public abstract JSONObject addCompany(JSONObject params);

    public abstract JSONObject getEmployeeList(JSONObject params);

    public abstract JSONObject getEmployeeInfo(String employeeId);

    public abstract JSONObject getEmployeeListAll(JSONObject params);

    public abstract JSONObject getEmployeeListProject(JSONObject params);

    public abstract JSONObject addEmployee(JSONObject params);

    public abstract JSONObject projectAddEmp(JSONObject params);

    public abstract JSONObject projectEmpList(JSONObject params);

    public abstract JSONObject attendanceList(JSONObject params);

    public abstract JSONObject attendanceDetail(JSONObject params);
    
    public abstract JSONObject attendance(JSONObject params);

}
