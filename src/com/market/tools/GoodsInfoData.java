package com.market.tools;

import java.util.List;

/*
 * 
 * 商品所有信息的包装类
 */
public class GoodsInfoData {
	private int code;
	private List<GoodsData> data;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public List<GoodsData> getData() {
		return data;
	}
	public void setData(List<GoodsData> data) {
		this.data = data;
	}
	public GoodsInfoData(int code, List<GoodsData> data) {
		super();
		this.code = code;
		this.data = data;
	}
	public GoodsInfoData() {

	}
	
}
