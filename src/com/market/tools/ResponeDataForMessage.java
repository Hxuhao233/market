package com.market.tools;

import java.util.List;

import com.market.model.Message;

public class ResponeDataForMessage {
	private int code;
	private String info;
	private List<Message> data;
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
	public List<Message> getData() {
		return data;
	}
	public void setData(List<Message> data) {
		this.data = data;
	}
	
}
