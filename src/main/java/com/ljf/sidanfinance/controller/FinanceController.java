package com.ljf.sidanfinance.controller;

import com.alibaba.fastjson.JSONObject;
import com.ljf.sidanfinance.service.IFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@CrossOrigin
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

    @RequestMapping(value="/project/info",method = RequestMethod.GET)
    public void projectInfo(HttpServletRequest request, HttpServletResponse response){
        String projectId = request.getParameter("projectId");
        JSONObject info = financeService.getProjectInfo(projectId);
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

    @RequestMapping(value="/employee/info",method = RequestMethod.GET)
    public void employeeInfo(HttpServletRequest request, HttpServletResponse response){
        String employeeId = request.getParameter("employeeId");
        JSONObject info = financeService.getEmployeeInfo(employeeId);
        returnInfo(response,info);
    }

    @RequestMapping(value="/employee/list/all",method = RequestMethod.GET)
    public void employeeListAll(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.getEmployeeListAll(getParams(request));
        returnInfo(response,info);
    }

    @RequestMapping(value="/employee/list/project",method = RequestMethod.GET)
    public void employeeListProject(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.getEmployeeListProject(getParams(request));
        returnInfo(response,info);
    }

    @RequestMapping(value="/employee/add",method = RequestMethod.POST)
    public void addEmployee(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.addEmployee(getParams(request));
        returnInfo(response,info);
    }

    @RequestMapping(value="/attendance/year",method = RequestMethod.GET)
    public void attendanceYear(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.attendanceYear(getParams(request));
        returnInfo(response,info);
    }

    @RequestMapping(value="/attendance/year/data",method = RequestMethod.GET)
    public void attendanceYearData(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.attendanceYearData(getParams(request));
        returnInfo(response,info);
    }

    @RequestMapping(value="/attendance/calendar",method = RequestMethod.GET)
    public void attendanceCalendar(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.attendanceCalendar(getParams(request));
        returnInfo(response,info);
    }

    @RequestMapping(value="/attendance/calendar/update",method = RequestMethod.POST)
    public void attendanceCalendarUpdate(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.attendanceCalendarUpdate(getParams(request));
        returnInfo(response,info);
    }

    @RequestMapping(value="/attendance/salary/update",method = RequestMethod.POST)
    public void attendanceSalaryUpdate(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.attendanceSalaryUpdate(getParams(request));
        returnInfo(response,info);
    }

    @RequestMapping(value="/project/cost/employee/add",method = RequestMethod.POST)
    public void projectAddEmp(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.projectAddEmp(getParams(request));
        returnInfo(response,info);
    }

    @RequestMapping(value="/project/cost/employee/list",method = RequestMethod.GET)
    public void projectEmpList(HttpServletRequest request, HttpServletResponse response){
        JSONObject info = financeService.projectEmpList(getParams(request));
        returnInfo(response,info);
    }

}
