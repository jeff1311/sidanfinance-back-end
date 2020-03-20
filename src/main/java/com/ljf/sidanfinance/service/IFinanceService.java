package com.ljf.sidanfinance.service;

import com.alibaba.fastjson.JSONObject;

public interface IFinanceService {

    public abstract JSONObject getIndexData();

    public abstract JSONObject getProjectList(JSONObject params);

    public abstract JSONObject addProject(JSONObject params);

}
