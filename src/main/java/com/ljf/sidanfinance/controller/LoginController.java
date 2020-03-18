package com.ljf.sidanfinance.controller;

import com.ljf.sidanfinance.dao.model.Code;
import com.ljf.sidanfinance.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/sidan/finance")
public class LoginController extends BaseController {

    @Autowired
    ILoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response){
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        Code code = loginService.login(account, password);
        returnInfo(response,code);
    }

}
