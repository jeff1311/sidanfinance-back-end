package com.ljf.sidanfinance.dao.model;

import com.alibaba.fastjson.JSONObject;

public enum Code {
	
	//通用码
	SUCCESS(0,"成功"),
	FAILURE(1,"失败");
	
	private int code;
	private String msg;
	
	Code(int code,String msg){
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return this.code;
	}

	public String getCodeStr() {
		return String.valueOf(this.code);
	}
	
	public String getMsg() {
		return this.msg;
	}

	/**
	 * 返回JSON格式
	 * @return
	 */
	public JSONObject toJson(){
		JSONObject result = new JSONObject();
		result.put("code", this.code);
		result.put("msg", this.msg);
		return result;
	}
	
	/**
	 * 插入进一个JSONObject对象里
	 * @param json
	 * @return
	 */
	public JSONObject toJson(JSONObject json){
		JSONObject result = new JSONObject();
		result.put("code", this.code);
		result.put("msg", this.msg);
		result.put("info", json);
		return result;
	}
	
	/**
	 * 重写错误信息
	 * @param msg
	 * @return
	 */
	public JSONObject toJson(String msg){
		JSONObject result = new JSONObject();
		result.put("code", this.code);
		result.put("msg", msg);
		return result;
	}
	
	/**
	 * 插入进一个JSONObject对象里（自定义错误信息，错误信息微调的情况下使用）
	 * @param json
	 * @param msg
	 * @return
	 */
	public JSONObject toJson(JSONObject json,String msg){
		JSONObject result = new JSONObject();
		result.put("code", this.code);
		result.put("msg", msg);
		result.put("info", json);
		return result;
	}
	
	/**
	 * 自定义
	 * @param <T>
	 * @param objName
	 * @param obj
	 * @return
	 */
	public <T> JSONObject toJson(String objName,T obj) {
		JSONObject result = new JSONObject();
		result.put("code", this.code);
		result.put("msg", msg);
		result.put(objName, obj);
		return result;
	}
	
}
