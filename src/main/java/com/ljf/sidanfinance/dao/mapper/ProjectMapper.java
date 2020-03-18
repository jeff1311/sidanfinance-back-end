package com.ljf.sidanfinance.dao.mapper;

import com.ljf.sidanfinance.dao.model.Project;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

public interface ProjectMapper extends Mapper<Project> {

    public abstract List<HashMap<String,String>> getListPage();

}