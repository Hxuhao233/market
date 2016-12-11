package com.market.tools;

import java.util.List;

/**
 * @author ck
 *
 */
public class ResponeDataForCollectList {
	private int code;
	private String info;
	private List<Integer> data;

	public ResponeDataForCollectList() {
		super();
	}

	public ResponeDataForCollectList(int code, String info, List<Integer> collectList) {
		super();
		this.code = code;
		this.info = info;
		this.data = collectList;
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

	public List<Integer> getData() {
		return data;
	}

	public void setData(List<Integer> data) {
		this.data = data;
	}

}