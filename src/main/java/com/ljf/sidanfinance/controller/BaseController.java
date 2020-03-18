package com.ljf.sidanfinance.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ljf.sidanfinance.dao.model.Code;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BaseController {

    private Logger logger = LoggerFactory.getLogger(BaseController.class);

    public <T> void returnInfo(HttpServletResponse response, String code, String errMsg, String objName, T obj) {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = null;
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("errMsg", errMsg);
        json.put(objName, obj);
        try {
            pw = response.getWriter();
            pw.print(json.toJSONString());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            logger.error("returnInfo 异常",e);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    public void returnInfo(HttpServletResponse response, String code, String errMsg) {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = null;
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("errMsg", errMsg);
        try {
            pw = response.getWriter();
            pw.print(json.toJSONString());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            logger.error("returnInfo 异常",e);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    public void returnInfo(HttpServletResponse response, int code, String errMsg) {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = null;
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("errMsg", errMsg);
        try {
            pw = response.getWriter();
            pw.print(json.toJSONString());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            logger.error("returnInfo 异常",e);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    public <T> void returnInfo(HttpServletResponse response, int code, String errMsg, String objName, T obj) {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = null;
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("errMsg", errMsg);
        json.put(objName, obj);
        try {
            pw = response.getWriter();
            pw.print(json.toJSONString());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            logger.error("returnInfo 异常",e);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    public void returnInfo(HttpServletResponse response, JSONObject json) {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            pw.print(json.toJSONString());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            logger.error("returnInfo 异常",e);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    public void returnInfo(HttpServletResponse response, Code code) {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            pw.print(code.toJson());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            logger.error("returnInfo 异常",e);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    /**
     * 从request里解析JSONObject
     * @param request
     * @return
     */
    public JSONObject getParams(HttpServletRequest request) {
        return JSON.parseObject(JSON.toJSONString(request.getParameterMap()).replace(":[", ":").replace("],", ",").replace("]}", "}"));
    }

}
