package com.market.tools;

import java.util.List;

import com.market.model.ContactWays;
import com.market.model.Goods;

public class GoodsData {
	private String imagePath;
	private Goods goods;
	private ContactWays contactWays;
	public GoodsData() {
		// TODO Auto-generated constructor stub
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public ContactWays getContactWays() {
		return contactWays;
	}
	public void setContactWays(ContactWays contactWays) {
		this.contactWays = contactWays;
	}


}
