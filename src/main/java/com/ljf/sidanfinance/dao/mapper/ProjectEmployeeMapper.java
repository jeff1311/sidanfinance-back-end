package com.ljf.sidanfinance.dao.mapper;

import com.alibaba.fastjson.JSONObject;
import com.ljf.sidanfinance.dao.model.ProjectEmployee;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface ProjectEmployeeMapper extends Mapper<ProjectEmployee> {

    public abstract ProjectEmployee getByProjectIdAndEmpId(@Param("projectId")Integer projectId,@Param("employeeId")Integer employeeId);

    public abstract List<Map<String, String>> getList(@Param("params")JSONObject params);

}