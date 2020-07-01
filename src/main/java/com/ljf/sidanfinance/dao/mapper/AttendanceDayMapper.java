package com.ljf.sidanfinance.dao.mapper;

import com.alibaba.fastjson.JSONObject;
import com.ljf.sidanfinance.dao.model.AttendanceDay;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AttendanceDayMapper extends Mapper<AttendanceDay> {

    public abstract List<JSONObject> getList(@Param("params")JSONObject params);

    public abstract AttendanceDay getInfo(@Param("id")String attendanceDayId);

}