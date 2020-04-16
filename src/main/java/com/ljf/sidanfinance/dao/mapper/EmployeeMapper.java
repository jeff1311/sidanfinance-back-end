package com.ljf.sidanfinance.dao.mapper;

import com.alibaba.fastjson.JSONObject;
import com.ljf.sidanfinance.dao.model.Employee;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper extends Mapper<Employee> {

    public abstract List<Map<String,String>> getList(@Param("params") JSONObject params);

    public abstract List<Map<String,String>> getProjectList(@Param("params") JSONObject params);

}