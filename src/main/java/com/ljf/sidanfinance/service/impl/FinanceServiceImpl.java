package com.ljf.sidanfinance.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ljf.sidanfinance.dao.mapper.ProjectMapper;
import com.ljf.sidanfinance.dao.model.Project;
import com.ljf.sidanfinance.service.IFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("financeService")
public class FinanceServiceImpl implements IFinanceService {

    @Autowired
    ProjectMapper projectMapper;

    @Override
    public JSONObject getIndexData() {
        List<Project> list = projectMapper.selectAll();
        JSONObject info = new JSONObject();
        info.put("code",0);
        info.put("list",list);
        return info;
    }

}
