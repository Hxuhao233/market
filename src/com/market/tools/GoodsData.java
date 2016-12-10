package com.market.tools;

import java.util.List;

import com.market.model.Comments;
import com.market.model.ContactWays;
import com.market.model.Goods;

/**
 * 用来存放一个商品包含的所有数据 主要用于商品详情
 * @author hxuhao
 *
 */
public class GoodsData {

	private String imagePath;
	private Goods goods;
	private ContactWays contactWays;
	private List<Comments> comments;
	
	public GoodsData() {
		
	}
	public GoodsData(Goods goods, ContactWays contactWays,String imagePath ) {
		super();
		this.imagePath = imagePath;
		this.goods = goods;
		this.contactWays = contactWays;
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
	public List<Comments> getComments() {
		return comments;
	}
	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}


}
