package com.ljf.sidanfinance.dao.mapper;

import com.ljf.sidanfinance.dao.model.Admin;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface AdminMapper extends Mapper<Admin> {

    public abstract Admin getByAccountAndPassword(@Param("account")String account, @Param("password")String password);

}