package com.ljf.sidanfinance.dao.mapper;

import com.alibaba.fastjson.JSONObject;
import com.ljf.sidanfinance.dao.model.Company;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface CompanyMapper extends Mapper<Company> {

    public abstract List<Company> getList(@Param("params") JSONObject params);

}