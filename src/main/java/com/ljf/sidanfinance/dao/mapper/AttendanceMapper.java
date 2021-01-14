package com.ljf.sidanfinance.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.alibaba.fastjson.JSONObject;
import com.ljf.sidanfinance.dao.model.Attendance;

import tk.mybatis.mapper.common.Mapper;

public interface AttendanceMapper extends Mapper<Attendance> {
    
	 public abstract List<JSONObject> getList(@Param("params") JSONObject params);
	
}