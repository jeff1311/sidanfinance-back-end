package com.ljf.sidanfinance.dao.mapper;

import com.alibaba.fastjson.JSONObject;
import com.ljf.sidanfinance.dao.model.AttendanceDay;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface AttendanceDayMapper extends Mapper<AttendanceDay> {

    public abstract List<String> getYear(@Param("params")JSONObject params);

    public abstract AttendanceDay getByDate(@Param("date")String date);

    public abstract List<Map<String,String>> getAttendace(@Param("params")JSONObject params);

}