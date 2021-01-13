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

import java.math.BigDecimal;
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
    EmployeeSalaryMapper employeeSalaryMapper;
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
    public JSONObject getProjectInfo(String projectId) {
        JSONObject info = projectMapper.getInfo(projectId);
        JSONObject result = Code.SUCCESS.toJson();
        result.put("info", info);
        return result;
    }

    @Override
    public JSONObject addProject(JSONObject params) {
        Project project = new Project();
        project.setName(params.getString("projectName"));
        project.setNo(params.getString("projectNo"));
        project.setContractNo(params.getString("contractNo"));
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
        project.setManager(params.getInteger("manager"));
        project.setGeneralManager(params.getInteger("generalManager"));
        project.setProvince(params.getString("province"));
        project.setCity(params.getString("city"));
        project.setStatus(params.getByte("status"));
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
        if(params.getInteger("page") != null){
            PageHelper.startPage(params.getInteger("page"),params.getInteger("limit"));
        }
        List<Map<String, String>> list = employeeMapper.getList(params);
        PageInfo pageInfo = new PageInfo(list);
//        PageHelper.clearPage();
        JSONObject info = Code.SUCCESS.toJson();
        info.put("count", pageInfo.getTotal());
        info.put("data", JSON.parseArray(JSON.toJSONString(list)));
        return info;
    }

    @Override
    public JSONObject getEmployeeInfo(String employeeId) {
        JSONObject info = employeeMapper.getInfo(employeeId);
        JSONObject result = Code.SUCCESS.toJson();
        result.put("info", info);
        return result;
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
        employee.setGender(params.getByte("gender"));
        employee.setPhone(params.getString("phone"));
        employee.setCertNo(params.getString("certNo"));
        employee.setBankNo(params.getString("bankNo"));
        employee.setSuperior(params.getInteger("superior"));
        employee.setManager(params.getInteger("manager"));
        employee.setBankName(params.getString("bankName"));
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

//    @Override
//    public JSONObject attendanceYear(JSONObject params) {
//        List<String> list = attendanceDayMapper.getYear(params);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
//        String thisYear = sdf.format(new Date());
//        List<EmployeeSalary> esList = employeeSalaryMapper.getByYear(params.getInteger("employeeId"),
//                params.getInteger("projectId"), thisYear);
//        if(esList.size() < 12){
//            for(int i = 1;i <= 12;i ++){
//                EmployeeSalary es = employeeSalaryMapper.getByMonth(params.getInteger("employeeId"),
//                        params.getInteger("projectId"), thisYear, String.valueOf(i));
//                if(es == null){
//                    es = new EmployeeSalary();
//                    es.setEmployeeId(params.getInteger("employeeId"));
//                    es.setProjectId(params.getInteger("projectId"));
//                    es.setYear(thisYear);
//                    es.setMonth(String.valueOf(i));
//                    es.setDateInsert(new Date());
//                    employeeSalaryMapper.insertSelective(es);
//                }
//            }
//            esList = employeeSalaryMapper.getByYear(params.getInteger("employeeId"),
//                    params.getInteger("projectId"), thisYear);
//        }
//        if(list.size() == 0 || !list.contains(thisYear)){
//            list.add(thisYear);
//        }
//        JSONObject info = Code.SUCCESS.toJson();
//        info.put("list", JSON.parseArray(JSON.toJSONString(list)));
//        info.put("esList", JSON.parseArray(JSON.toJSONString(esList)));
//        return info;
//    }
//
//    @Override
//    public JSONObject attendanceYearData(JSONObject params) {
//        List<EmployeeSalary> esList = employeeSalaryMapper.getByYear(params.getInteger("employeeId"),
//                params.getInteger("projectId"), params.getString("year"));
//        if(esList.size() < 12){
//            for(int i = 1;i <= 12;i ++){
//                EmployeeSalary es = employeeSalaryMapper.getByMonth(params.getInteger("employeeId"),
//                        params.getInteger("projectId"), params.getString("year"), String.valueOf(i));
//                if(es == null){
//                    es = new EmployeeSalary();
//                    es.setEmployeeId(params.getInteger("employeeId"));
//                    es.setProjectId(params.getInteger("projectId"));
//                    es.setYear(params.getString("year"));
//                    es.setMonth(String.valueOf(i));
//                    es.setDateInsert(new Date());
//                    employeeSalaryMapper.insertSelective(es);
//                }
//            }
//            esList = employeeSalaryMapper.getByYear(params.getInteger("employeeId"),
//                    params.getInteger("projectId"), params.getString("year"));
//        }
//        JSONObject info = Code.SUCCESS.toJson();
//        info.put("esList", JSON.parseArray(JSON.toJSONString(esList)));
//        return info;
//    }
//
//    @Override
//    public JSONObject attendanceCalendar(JSONObject params) {
//        List<Map<String,String>> list = attendanceDayMapper.getAttendace(params);
//        JSONObject info = Code.SUCCESS.toJson();
//        info.put("calendar",JSON.parseArray(JSON.toJSONString(list)));
//        return info;
//    }
//
//    @Override
//    public JSONObject attendanceCalendarUpdate(JSONObject params) {
//        Integer projectId = params.getInteger("projectId");
//        Integer employeeId = params.getInteger("employeeId");
//        String year = params.getString("year");
//        String month = String.valueOf(params.getInteger("month"));
//        JSONArray days = JSON.parseArray(params.getString("days"));
//        for(Object day : days){
//            JSONObject d = JSON.parseObject(String.valueOf(day));
//            AttendanceDay ad = attendanceDayMapper.getByDate(d.getString("date"));
//            if(ad == null){
//                ad = new AttendanceDay();
//                ad.setProjectId(projectId);
//                ad.setEmployeeId(employeeId);
//                ad.setForenoon(d.getBoolean("forenoon"));
//                ad.setAfternoon(d.getBoolean("afternoon"));
//                ad.setHour(d.getByte("hour"));
//                ad.setDate(d.getDate("date"));
//                ad.setDateInsert(new Date());
//                attendanceDayMapper.insertSelective(ad);
//            }else{
//                ad.setProjectId(projectId);
//                ad.setEmployeeId(employeeId);
//                ad.setForenoon(d.getBoolean("forenoon"));
//                ad.setAfternoon(d.getBoolean("afternoon"));
//                ad.setHour(d.getByte("hour"));
//                ad.setDate(d.getDate("date"));
//                ad.setDateUpdate(new Date());
//                attendanceDayMapper.updateByPrimaryKeySelective(ad);
//            }
//        }
//        //更新工资表
//        EmployeeSalary es = employeeSalaryMapper.getByMonth(employeeId,projectId,year,month);
//        if(es != null){
//            Map<String, String> m = attendanceDayMapper.sumMonth(params);
//            double day = Double.parseDouble(String.valueOf(m.get("day")));
//            int hour = Integer.parseInt(String.valueOf(m.get("hour")));
//            es.setDay(day);
//            es.setHour(hour);
//            //工资计算公式（（工时 / 6 + 工日） * 工价） + 奖金 - 支款）
//            BigDecimal bd1 = new BigDecimal(hour);//工时
//            BigDecimal bd2 = new BigDecimal(day);//工日
//            BigDecimal bd3 = new BigDecimal(es.getPrice());//工价
//            BigDecimal bd4 = new BigDecimal(es.getBonus());//奖励
//            BigDecimal bd5 = new BigDecimal(es.getWithdraw());//支款
//            double amount = bd1.divide(new BigDecimal(6),2, BigDecimal.ROUND_HALF_UP).add(bd2).
//                    multiply(bd3).setScale(2,BigDecimal.ROUND_HALF_UP).
//                    add(bd4).subtract(bd5).doubleValue();
//            es.setAmount(amount);
//            employeeSalaryMapper.updateByPrimaryKeySelective(es);
//        }
//        return Code.SUCCESS.toJson();
//    }
//
//    @Override
//    public JSONObject attendanceSalaryUpdate(JSONObject params) {
//        Integer projectId = params.getInteger("projectId");
//        Integer employeeId = params.getInteger("employeeId");
//        String year = params.getString("year");
//        String month = String.valueOf(params.getInteger("month"));
//        EmployeeSalary es = employeeSalaryMapper.getByMonth(employeeId,projectId,year,month);
//        if(es != null){
//            es.setPrice(params.getDouble("price"));
//            es.setBonus(params.getDouble("bonus"));
//            es.setWithdraw(params.getDouble("withdraw"));
//            es.setAmount(params.getDouble("amount"));
//            es.setActualAmount(params.getDouble("actualAmount"));
//            es.setDateUpdate(new Date());
//            employeeSalaryMapper.updateByPrimaryKeySelective(es);
//        }
//        return Code.SUCCESS.toJson();
//    }

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

    @Override
    public JSONObject attendanceDayList(JSONObject params) {
        PageHelper.startPage(params.getInteger("page"),params.getInteger("limit"));
        List<JSONObject> list = attendanceDayMapper.getList(params);
        PageInfo pageInfo = new PageInfo(list);
        JSONObject info = Code.SUCCESS.toJson();
        info.put("count", pageInfo.getTotal());
        info.put("data", list);
        return info;
    }

    @Override
    public JSONObject attendanceDayInfo(JSONObject params) {
        //项目列表
        List<Map<String, String>> list = projectMapper.getList(params);
        JSONObject result = Code.SUCCESS.toJson();
        result.put("projectList", JSON.parseArray(JSON.toJSONString(list)));
        //考勤基本信息
        AttendanceDay attendanceDayInfo = attendanceDayMapper.getInfo(params.getString("id"));
        result.put("info",attendanceDayInfo);
        return result;
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
