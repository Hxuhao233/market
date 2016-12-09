package com.market.tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 返回给网页的消息对象
 * 
 * @author hxuhao
 *
 */
public class ResponeData {
	private int code;
	private String info;
	// private String auth;
	private List<Map<String, String>> data;

	public ResponeData() {

	}

	/*
	 * public String getAuth() { return auth; }
	 * 
	 * public void setAuth(String auth) { this.auth = auth; }
	 */
	public ResponeData(int c, String i) {
		code = c;
		info = i;
	}

	public List<Map<String, String>> getData() {
		return data;
	}

	public void addData(Map<String, String> item) {
		data.add(item);
	}

	public void setData(List<Map<String, String>> data) {
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
