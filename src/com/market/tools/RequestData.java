package com.market.tools;

/**
 * 用户请求数据包装类　
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestData {
	private List<Map<String, String>> data;

	public RequestData() {
		data = new ArrayList<Map<String, String>>();

	}

	public List<Map<String, String>> getData() {
		return data;
	}

	public void setData(List<Map<String, String>> data) {
		this.data = data;
	}

}
