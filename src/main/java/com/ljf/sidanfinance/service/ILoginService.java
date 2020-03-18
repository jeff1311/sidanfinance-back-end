package com.ljf.sidanfinance.service;

import com.alibaba.fastjson.JSONObject;
import com.ljf.sidanfinance.dao.model.Code;

public interface ILoginService {

    public abstract Code login(String account, String password);

}
