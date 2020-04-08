package com.ljf.sidanfinance.service;

import com.alibaba.fastjson.JSONObject;

public interface IFinanceService {

    public abstract JSONObject getIndexData();

    public abstract JSONObject getProjectList(JSONObject params);

    public abstract JSONObject addProject(JSONObject params);

    public abstract JSONObject getCompanyList(JSONObject params);

    public abstract JSONObject addCompany(JSONObject params);

    public abstract JSONObject getEmployeeList(JSONObject params);

    public abstract JSONObject getEmployeeListAll(JSONObject params);

    public abstract JSONObject addEmployee(JSONObject params);

    public abstract JSONObject attendanceCalendar(JSONObject params);

}
