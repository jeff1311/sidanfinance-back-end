package com.ljf.sidanfinance.service.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljf.sidanfinance.dao.mapper.AttendanceDetailMapper;
import com.ljf.sidanfinance.dao.mapper.AttendanceMapper;
import com.ljf.sidanfinance.dao.mapper.CalenMapper;
import com.ljf.sidanfinance.dao.mapper.CompanyMapper;
import com.ljf.sidanfinance.dao.mapper.EmployeeMapper;
import com.ljf.sidanfinance.dao.mapper.EmployeeSalaryMapper;
import com.ljf.sidanfinance.dao.mapper.ProjectEmployeeMapper;
import com.ljf.sidanfinance.dao.mapper.ProjectMapper;
import com.ljf.sidanfinance.dao.model.Attendance;
import com.ljf.sidanfinance.dao.model.AttendanceDetail;
import com.ljf.sidanfinance.dao.model.Code;
import com.ljf.sidanfinance.dao.model.Company;
import com.ljf.sidanfinance.dao.model.Employee;
import com.ljf.sidanfinance.dao.model.Project;
import com.ljf.sidanfinance.dao.model.ProjectEmployee;
import com.ljf.sidanfinance.service.IFinanceService;


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
    AttendanceMapper attendanceMapper;
    @Autowired
    AttendanceDetailMapper attendanceDetailMapper;

    @Override
    public JSONObject getIndexData() {

        return null;
    }

    @Override
    public JSONObject getProjectList(JSONObject params) {
        PageHelper.startPage(params.getInteger("page"),params.getInteger("limit"));
        List<Map<String, String>> list = projectMapper.getList(params);
        PageInfo<Map<String, String>> pageInfo = new PageInfo<>(list);
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
        PageInfo<Map<String, String>> pageInfo = new PageInfo<>(list);
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
        PageInfo<Map<String, String>> pageInfo = new PageInfo<>(list);
        JSONObject info = Code.SUCCESS.toJson();
        info.put("list", JSON.parseArray(JSON.toJSONString(list)));
        return info;
    }

    @Override
    public JSONObject getEmployeeListProject(JSONObject params) {
        List<Map<String, String>> list = employeeMapper.getProjectList(params);
        PageInfo<Map<String, String>> pageInfo = new PageInfo<>(list);
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
        PageInfo<Map<String, String>> pageInfo = new PageInfo<>(list);
        JSONObject info = Code.SUCCESS.toJson();
        info.put("count", pageInfo.getTotal());
        info.put("data", JSON.parseArray(JSON.toJSONString(list)));
        return info;
    }

    @Override
    public JSONObject attendanceList(JSONObject params) {
        PageHelper.startPage(params.getInteger("page"),params.getInteger("limit"));
        List<JSONObject> list = attendanceMapper.getList(params);
        PageInfo<JSONObject> pageInfo = new PageInfo<>(list);
        JSONObject info = Code.SUCCESS.toJson();
        info.put("count", pageInfo.getTotal());
        info.put("data", list);
        return info;
    }

    @Override
    public JSONObject attendanceDetail(JSONObject params) {
        //项目列表
        List<Map<String, String>> list = projectMapper.getList(params);
        JSONObject result = Code.SUCCESS.toJson();
        result.put("projectList", JSON.parseArray(JSON.toJSONString(list)));
        //考勤基本信息
//        AttendanceDay attendanceDayInfo = attendanceDetailMapper.getInfo(params.getString("id"));
//        result.put("info",attendanceDayInfo);
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

	@Override
	public JSONObject attendance(JSONObject params) {
		//考勤ID
		Integer attendanceId = params.getInteger("attendanceId");
		//项目ID
		Integer projectId = params.getInteger("projectId");
		//工种
		Integer type = params.getInteger("type");
		//年份
		Integer year = params.getInteger("year");
		//月份
		Integer month = params.getInteger("month");
		//负责人
		Integer manager = params.getInteger("manager");
		Attendance a = new Attendance();
		a.setProjectId(projectId);
		a.setType(1);
		a.setEmpType(type);
		a.setYear(year);
		a.setMonth(month);
		a.setManager(manager);
		if(attendanceId == null) {
			a.setDateInsert(new Date());
			attendanceMapper.insertSelective(a);
			attendanceId = a.getId();
		}else {
			a.setId(attendanceId);
			a.setDateUpdate(new Date());
			attendanceMapper.updateByPrimaryKeySelective(a);
		}
		
		//工人考勤
		String empListStr = params.getString("empList");
		if(empListStr != null && !"".equals(empListStr.trim())) {
			List<JSONObject> empList = JSON.parseArray(empListStr,JSONObject.class);
			for(JSONObject emp : empList) {
				Integer empId = emp.getInteger("id");
				Double day = emp.getDouble("day");
				Double hour = emp.getDouble("hour");
				Double price = emp.getDouble("price");
				Double deduct = emp.getDouble("deduct");
				Double bonus = emp.getDouble("bonus");
				//点工（工时/6+工日）*工价
				Double amount = null;
				Double payAmount = null;
				if(day != null && hour != null && price != null) {
					amount = (hour / 6 + day) * price;
					payAmount = amount;
			        if(deduct != null) {
			        	payAmount -= deduct;
			        }
			        if(bonus != null) {
			        	payAmount += bonus;
			        }
			        BigDecimal bd1 = new BigDecimal(amount);
			        amount = bd1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			        BigDecimal bd2 = new BigDecimal(payAmount);
			        payAmount = bd2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				}
				AttendanceDetail ad = new AttendanceDetail();
				ad.setAttId(attendanceId);
				ad.setEmpId(empId);
				ad.setDay(day);
				ad.setHour(hour);
				ad.setPrice(price);
				ad.setAmount(amount);
				ad.setPayAmount(payAmount);
				ad.setDeductAmount(deduct);
				ad.setBonus(bonus);
				ad.setDateInsert(new Date());
				attendanceDetailMapper.insertSelective(ad);
			}
		}
		
		return Code.SUCCESS.toJson();
	}

}
