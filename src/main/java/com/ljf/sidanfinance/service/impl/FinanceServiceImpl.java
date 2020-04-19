package com.ljf.sidanfinance.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljf.sidanfinance.dao.mapper.*;
import com.ljf.sidanfinance.dao.model.*;
import com.ljf.sidanfinance.service.IFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("financeService")
public class FinanceServiceImpl implements IFinanceService {

    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    CompanyMapper companyMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    CalenMapper calenMapper;
    @Autowired
    ProjectEmployeeMapper projectEmployeeMapper;
    @Autowired
    AttendanceDayMapper attendanceDayMapper;

    @Override
    public JSONObject getIndexData() {

        return null;
    }

    @Override
    public JSONObject getProjectList(JSONObject params) {
        PageHelper.startPage(params.getInteger("page"),params.getInteger("limit"));
        List<Map<String, String>> list = projectMapper.getList(params);
        PageInfo pageInfo = new PageInfo(list);
//        PageHelper.clearPage();
        JSONObject info = Code.SUCCESS.toJson();
        info.put("count", pageInfo.getTotal());
        info.put("data", JSON.parseArray(JSON.toJSONString(list)));
        return info;
    }

    @Override
    public JSONObject addProject(JSONObject params) {
        Project project = new Project();
        project.setName(params.getString("projectName"));
        project.setNo(params.getString("projectNo"));
        project.setCompanyId(params.getInteger("companyId"));
        project.setContractSignDate(params.getDate("signDate"));
        Date startDate = params.getDate("startDate");
        Date endDate = params.getDate("endDate");
        Integer months = null;
        if(startDate != null && endDate != null){
            months = getMonthDiff(startDate,endDate);
        }
        project.setStartDate(startDate);
        project.setEndDate(endDate);
        project.setMonths(months);
        project.setTotalPrice(params.getDouble("totalPrice"));
        int result = 0;
        Integer projectId = params.getInteger("projectId");
        if(projectId != null){
            project.setId(projectId);
            project.setDateUpdate(new Date());
            project.setDeleteMark(params.getInteger("deleteMark"));
            result = projectMapper.updateByPrimaryKeySelective(project);
        }else{
            project.setDateInsert(new Date());
            project.setDeleteMark(0);
            result = projectMapper.insertSelective(project);
        }
        if(result == 1){
            return Code.SUCCESS.toJson();
        }else{
            return Code.FAILURE.toJson();
        }
    }

    @Override
    public JSONObject getCompanyList(JSONObject params) {
//        PageHelper.startPage(params.getInteger("page"),params.getInteger("limit"));
        List<Company> list = companyMapper.getList(params);
//        PageInfo pageInfo = new PageInfo(list);
//        PageHelper.clearPage();
        JSONObject info = Code.SUCCESS.toJson();
//        info.put("count", pageInfo.getTotal());
        info.put("data", JSON.parseArray(JSON.toJSONString(list)));
        return info;
    }

    @Override
    public JSONObject addCompany(JSONObject params) {
        Company company = new Company();
        company.setName(params.getString("companyName"));
        company.setGroupName(params.getString("groupName"));
        company.setDateInsert(new Date());
        int result = companyMapper.insertSelective(company);
        if(result == 1){
            return Code.SUCCESS.toJson();
        }else{
            return Code.FAILURE.toJson();
        }
    }

    @Override
    public JSONObject getEmployeeList(JSONObject params) {
        PageHelper.startPage(params.getInteger("page"),params.getInteger("limit"));
        List<Map<String, String>> list = employeeMapper.getList(params);
        PageInfo pageInfo = new PageInfo(list);
//        PageHelper.clearPage();
        JSONObject info = Code.SUCCESS.toJson();
        info.put("count", pageInfo.getTotal());
        info.put("data", JSON.parseArray(JSON.toJSONString(list)));
        return info;
    }

    @Override
    public JSONObject getEmployeeListAll(JSONObject params) {
        List<Map<String, String>> list = employeeMapper.getList(params);
        PageInfo pageInfo = new PageInfo(list);
        JSONObject info = Code.SUCCESS.toJson();
        info.put("list", JSON.parseArray(JSON.toJSONString(list)));
        return info;
    }

    @Override
    public JSONObject getEmployeeListProject(JSONObject params) {
        List<Map<String, String>> list = employeeMapper.getProjectList(params);
        PageInfo pageInfo = new PageInfo(list);
        JSONObject info = Code.SUCCESS.toJson();
        info.put("list", JSON.parseArray(JSON.toJSONString(list)));
        return info;
    }

    @Override
    public JSONObject addEmployee(JSONObject params) {
        Employee employee = new Employee();
        employee.setName(params.getString("name"));
        employee.setType(params.getInteger("type"));
        int result = 0;
        Integer employeeId = params.getInteger("employeeId");
        if(employeeId != null){
            employee.setId(employeeId);
            employee.setDateUpdate(new Date());
            employee.setDeleteMark(params.getInteger("deleteMark"));
            result = employeeMapper.updateByPrimaryKeySelective(employee);
        }else{
            employee.setDateInsert(new Date());
            employee.setDeleteMark(0);
            result = employeeMapper.insertSelective(employee);
        }
        if(result == 1){
            return Code.SUCCESS.toJson();
        }else{
            return Code.FAILURE.toJson();
        }
    }

    @Override
    public JSONObject attendanceYear(JSONObject params) {
        List<String> list = attendanceDayMapper.getYear(params);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String thisYear = sdf.format(new Date());
        if(list.size() == 0 || !list.contains(thisYear)){
            list.add(thisYear);
        }
        JSONObject info = Code.SUCCESS.toJson();
        info.put("list", JSON.parseArray(JSON.toJSONString(list)));
        return info;
    }

    @Override
    public JSONObject attendanceCalendar(JSONObject params) {
        List<Map<String,String>> list = attendanceDayMapper.getAttendace(params);
        JSONObject info = Code.SUCCESS.toJson();
        info.put("calendar",JSON.parseArray(JSON.toJSONString(list)));
        return info;
    }

    @Override
    public JSONObject attendanceCalendarUpdate(JSONObject params) {
        Integer projectId = params.getInteger("projectId");
        Integer employeeId = params.getInteger("employeeId");
        JSONArray days = JSON.parseArray(params.getString("days"));
        Date now = new Date();
        for(Object day : days){
            JSONObject d = JSON.parseObject(String.valueOf(day));
            AttendanceDay ad = attendanceDayMapper.getByDate(d.getString("date"));
            if(ad == null){
                ad = new AttendanceDay();
                ad.setProjectId(projectId);
                ad.setEmployeeId(employeeId);
                ad.setForenoon(d.getBoolean("forenoon"));
                ad.setAfternoon(d.getBoolean("afternoon"));
                ad.setHour(d.getByte("hour"));
                ad.setDate(d.getDate("date"));
                ad.setDateInsert(now);
                attendanceDayMapper.insertSelective(ad);
            }else{
                ad.setProjectId(projectId);
                ad.setEmployeeId(employeeId);
                ad.setForenoon(d.getBoolean("forenoon"));
                ad.setAfternoon(d.getBoolean("afternoon"));
                ad.setHour(d.getByte("hour"));
                ad.setDate(d.getDate("date"));
                ad.setDateUpdate(now);
                attendanceDayMapper.updateByPrimaryKeySelective(ad);
            }
        }
        return Code.SUCCESS.toJson();
    }

    @Override
    public JSONObject projectAddEmp(JSONObject params) {
        Integer projectId = params.getInteger("projectId");
        String[] empIds = params.getString("empIds").split(",");
        for(String empId : empIds){
            ProjectEmployee pe = projectEmployeeMapper.getByProjectIdAndEmpId(projectId,Integer.parseInt(empId));
            if(pe == null){
                pe = new ProjectEmployee();
                pe.setProjectId(projectId);
                pe.setEmployeeId(Integer.parseInt(empId));
                pe.setDateInsert(new Date());
                pe.setDeleteMark(0);
                projectEmployeeMapper.insertSelective(pe);
            }
        }
        return Code.SUCCESS.toJson();
    }

    @Override
    public JSONObject projectEmpList(JSONObject params) {
        PageHelper.startPage(params.getInteger("page"),params.getInteger("limit"));
        List<Map<String, String>> list = projectEmployeeMapper.getList(params);
        PageInfo pageInfo = new PageInfo(list);
        JSONObject info = Code.SUCCESS.toJson();
        info.put("count", pageInfo.getTotal());
        info.put("data", JSON.parseArray(JSON.toJSONString(list)));
        return info;
    }

    /**
     * 获取两个日期相差的月数
     */
    public static int getMonthDiff(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int month2 = c2.get(Calendar.MONTH);
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        int day2 = c2.get(Calendar.DAY_OF_MONTH);
        // 获取年的差值 
        int yearInterval = year1 - year2;
        // 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数
        if (month1 < month2 || month1 == month2 && day1 < day2) {
            yearInterval--;
        }
        // 获取月数差值
        int monthInterval = (month1 + 12) - month2;
        if (day1 < day2) {
            monthInterval--;
        }
        monthInterval %= 12;
        int monthsDiff = Math.abs(yearInterval * 12 + monthInterval);
        return monthsDiff;
    }

}
