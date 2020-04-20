package com.ljf.sidanfinance.dao.mapper;

import com.ljf.sidanfinance.dao.model.EmployeeSalary;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface EmployeeSalaryMapper extends Mapper<EmployeeSalary> {

    public abstract EmployeeSalary getMonthData(@Param("employeeId")Integer employeeId,
                                                @Param("projectId")Integer projectId,
                                                @Param("year")String year,
                                                @Param("month")String month);

}