package com.market.tools;

/**
 * 响应信息包装类 不带复杂数据
 * 
 * @author hxuhao
 *
 */
public class BaseResponeData {
	private int code;
	private String info;

	public BaseResponeData() {

	}

	public BaseResponeData(int c, String i) {
		code = c;
		info = i;
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
