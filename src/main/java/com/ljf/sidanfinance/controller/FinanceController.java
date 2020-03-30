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
    public void projectList(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.getProjectList(getParams(request));
        returnInfo(response,info);
    }

    @RequestMapping(value="/project/add",method = RequestMethod.POST)
    public void addProject(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.addProject(getParams(request));
        returnInfo(response,info);
    }

    @RequestMapping(value="/company/list",method = RequestMethod.GET)
    public void companyList(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.getCompanyList(getParams(request));
        returnInfo(response,info);
    }

    @RequestMapping(value="/company/add",method = RequestMethod.POST)
    public void addCompany(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.addCompany(getParams(request));
        returnInfo(response,info);
    }

    @RequestMapping(value="/employee/list",method = RequestMethod.GET)
    public void employeeList(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.getEmployeeList(getParams(request));
        returnInfo(response,info);
    }

    @RequestMapping(value="/employee/add",method = RequestMethod.POST)
    public void addEmployee(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.addEmployee(getParams(request));
        returnInfo(response,info);
    }

    @RequestMapping(value="/attendance/calendar",method = RequestMethod.GET)
    public void attendanceCalendar(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.attendanceCalendar(getParams(request));
        returnInfo(response,info);
    }

}
