package com.ljf.sidanfinance.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.ljf.sidanfinance.service.IFinanceService;

@Controller
@CrossOrigin
@RequestMapping("/sidan/finance")
public class FinanceController extends BaseController {

    @Autowired
    IFinanceService financeService;

    @GetMapping("/index")
    public void index(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.getIndexData();
        returnInfo(response,info);
    }

    @GetMapping("/project/list")
    public void projectList(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.getProjectList(getParams(request));
        returnInfo(response,info);
    }

    @GetMapping("/project/info")
    public void projectInfo(HttpServletRequest request, HttpServletResponse response){
        String projectId = request.getParameter("projectId");
        JSONObject info = financeService.getProjectInfo(projectId);
        returnInfo(response,info);
    }

    @PostMapping("/project/add")
    public void addProject(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.addProject(getParams(request));
        returnInfo(response,info);
    }

    @GetMapping("/company/list")
    public void companyList(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.getCompanyList(getParams(request));
        returnInfo(response,info);
    }

    @PostMapping("/company/add")
    public void addCompany(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.addCompany(getParams(request));
        returnInfo(response,info);
    }

    @GetMapping("/employee/list")
    public void employeeList(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.getEmployeeList(getParams(request));
        returnInfo(response,info);
    }

    @GetMapping("/employee/info")
    public void employeeInfo(HttpServletRequest request, HttpServletResponse response){
        String employeeId = request.getParameter("employeeId");
        JSONObject info = financeService.getEmployeeInfo(employeeId);
        returnInfo(response,info);
    }

    @GetMapping("/employee/list/all")
    public void employeeListAll(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.getEmployeeListAll(getParams(request));
        returnInfo(response,info);
    }

    @GetMapping("/employee/list/project")
    public void employeeListProject(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.getEmployeeListProject(getParams(request));
        returnInfo(response,info);
    }

    @PostMapping("/employee/add")
    public void addEmployee(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.addEmployee(getParams(request));
        returnInfo(response,info);
    }

    @PostMapping("/project/cost/employee/add")
    public void projectAddEmp(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.projectAddEmp(getParams(request));
        returnInfo(response,info);
    }

    @GetMapping("/project/cost/employee/list")
    public void projectEmpList(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.projectEmpList(getParams(request));
        returnInfo(response,info);
    }

    @GetMapping("/attendance/list")
    public void attendanceList(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.attendanceList(getParams(request));
        returnInfo(response,info);
    }

    @GetMapping("/attendance/detail")
    public void attendanceDetail(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.attendanceDetail(getParams(request));
        returnInfo(response,info);
    }

    @PostMapping("/attendance")
    public void attendance(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.attendance(getParams(request));
        returnInfo(response,info);
    }
    
}
