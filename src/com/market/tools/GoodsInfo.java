package com.market.tools;

/**
 * 商品简要信息
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.market.model.Goods;

public class GoodsInfo {
	private Goods Good;
	private String pictureAddr;
	
	public Goods getGood() {
		return Good;
	}

	public void setGood(Goods good) {
		Good = good;
	}

	public String getPictureAddr() {
		return pictureAddr;
	}

	public void setPictureAddr(String pictureAddr) {
		this.pictureAddr = pictureAddr;
	}

	public GoodsInfo() {
		
	}

	public GoodsInfo(Goods good, String pictureAddr) {
		super();
		Good = good;
		this.pictureAddr = pictureAddr;
	}
	
		
}
