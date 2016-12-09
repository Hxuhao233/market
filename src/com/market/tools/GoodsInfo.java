package com.market.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.market.model.Goods;

public class GoodsInfo {
	private Goods Good;
	private List<String> pictureAddr;

	public Goods getGood() {
		return Good;
	}

	public void setGood(Goods good) {
		Good = good;
	}

	public List<String> getPictureAddr() {
		return pictureAddr;
	}

	public void setPictureAddr(List<String> pictureAddr) {
		this.pictureAddr = pictureAddr;
	}

	public GoodsInfo() {

		pictureAddr = new ArrayList<String>();
	}
}
