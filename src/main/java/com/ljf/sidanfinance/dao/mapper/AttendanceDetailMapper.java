package com.ljf.sidanfinance.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.alibaba.fastjson.JSONObject;
import com.ljf.sidanfinance.dao.model.AttendanceDetail;

import tk.mybatis.mapper.common.Mapper;

public interface AttendanceDetailMapper extends Mapper<AttendanceDetail> {
    
	public abstract List<JSONObject> getList(@Param("params") JSONObject params);
	
	public abstract int deleteByAttId(@Param("attId") Integer attId);
	
}