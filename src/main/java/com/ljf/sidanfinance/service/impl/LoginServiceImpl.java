package com.ljf.sidanfinance.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ljf.sidanfinance.dao.mapper.AdminMapper;
import com.ljf.sidanfinance.dao.model.Admin;
import com.ljf.sidanfinance.dao.model.Code;
import com.ljf.sidanfinance.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements ILoginService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Code login(String account, String password) {
        Admin admin = adminMapper.getByAccountAndPassword(account, password);
        if(admin != null){
            return Code.SUCCESS;
        }else{
            return Code.FAILURE;
        }
    }

}
