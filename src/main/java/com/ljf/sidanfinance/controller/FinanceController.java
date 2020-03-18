package com.ljf.sidanfinance.controller;

import com.alibaba.fastjson.JSONObject;
import com.ljf.sidanfinance.service.IFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/sidan/finance")
public class FinanceController extends BaseController {

    @Autowired
    IFinanceService financeService;

    @RequestMapping(value="/index",method = RequestMethod.GET)
    public void index(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.getIndexData();
        returnInfo(response,info);
    }

    @RequestMapping(value="/project/list",method = RequestMethod.GET)
    public void project(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.getProjectList(getParams(request));
        returnInfo(response,info);
    }

}
