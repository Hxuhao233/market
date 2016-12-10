package com.market.tools;

import java.util.List;

/*
 * 
 * 商品简要信息的包装类
 */
public class GoodsInfoData {
	private int code;
	private List<GoodsInfo> data;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public List<GoodsInfo> getData() {
		return data;
	}
	public void setData(List<GoodsInfo> data) {
		this.data = data;
	}
	public GoodsInfoData(int code, List<GoodsInfo> data) {
		super();
		this.code = code;
		this.data = data;
	}
	
}
