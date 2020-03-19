package com.ljf.sidanfinance.dao.mapper;

import com.ljf.sidanfinance.dao.model.Project;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface ProjectMapper extends Mapper<Project> {

    public abstract List<HashMap<String,String>> getListPage();

    @Select("select * from project")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "no",column = "no"),
            @Result(property = "contractNo",column = "contract_no"),
            @Result(property = "companyId",column = "company_id")
    })
    public abstract List<Project> getAll();

}