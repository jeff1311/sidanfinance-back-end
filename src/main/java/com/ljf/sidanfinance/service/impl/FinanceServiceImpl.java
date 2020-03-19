package com.ljf.sidanfinance.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljf.sidanfinance.dao.mapper.ProjectMapper;
import com.ljf.sidanfinance.dao.model.Code;
import com.ljf.sidanfinance.dao.model.Project;
import com.ljf.sidanfinance.service.IFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("financeService")
public class FinanceServiceImpl implements IFinanceService {

    @Autowired
    ProjectMapper projectMapper;

    @Override
    public JSONObject getIndexData() {

        return null;
    }

    @Override
    public JSONObject getProjectList(JSONObject params) {
        PageHelper.startPage(params.getInteger("page"),params.getInteger("limit"));
        List<Map<String, String>> list = projectMapper.getListPage(params);
        PageInfo pageInfo = new PageInfo(list);
//        PageHelper.clearPage();
        System.out.println(JSON.parseArray(JSON.toJSONString(list)));
        JSONObject info = Code.SUCCESS.toJson();
        info.put("count", pageInfo.getTotal());
        info.put("data", JSON.parseArray(JSON.toJSONString(list)));
        return info;
    }

}
